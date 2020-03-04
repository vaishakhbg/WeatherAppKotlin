package com.comviva.kotlinweather.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRequest {

    private val base_url = "https://api.openweathermap.org/"
    val tokenID = "aa9a27e3bbe36c45d90d7851c687d904"


    fun getRetrofitObject(): Retrofit {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit

    }
}


