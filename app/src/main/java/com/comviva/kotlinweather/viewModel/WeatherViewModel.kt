package com.comviva.kotlinweather.viewModel

import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.comviva.kotlinweather.model.WeatherModel
import com.comviva.kotlinweather.retrofit.RetrofitRequest
import com.comviva.kotlinweather.retrofit.WeatherService
import com.comviva.kotlinweather.view.WeatherFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class WeatherViewModel : ViewModel() {

     val _weatherModel= MutableLiveData<WeatherModel>()
     val weatherModel:LiveData<WeatherModel> = _weatherModel

     val _cityID=MutableLiveData<String>()
     val city_id: LiveData<String> = _cityID



    val retrofitRequest = RetrofitRequest()


    fun loadNextFragment(v : View){
        loadWeather(v)


    }


    fun loadWeather(v:View) {

        var retrofit = retrofitRequest.getRetrofitObject()
        var weatherService = retrofit.create(WeatherService::class.java)
        if (!_cityID.value.isNullOrEmpty()) {
            val call = weatherService.getWeatherData(_cityID.value!!, retrofitRequest.tokenID)
            call.enqueue(object : Callback<WeatherModel> {
                override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                    Log.d("fail", t.message);

                }

                override fun onResponse(
                    call: Call<WeatherModel>,
                    response: Response<WeatherModel>
                ) {
                    if (response.code() == 200) {
                        val weatherResponse = response.body()!!
                        _weatherModel.value = weatherResponse
                        if (v.context is AppCompatActivity) {
                            (v.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                                .replace(com.comviva.kotlinweather.R.id.framee, WeatherFragment())
                                .addToBackStack(null)
                                .commit()
                        }
                    }
                }
            })
        }
    }

}