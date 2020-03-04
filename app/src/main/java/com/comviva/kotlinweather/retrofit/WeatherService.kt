package com.comviva.kotlinweather.retrofit

import com.comviva.kotlinweather.model.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("/data/2.5/weather?")
    fun getWeatherData(@Query("id")id:String, @Query("APPID") app_id:String):Call<WeatherModel>
}
