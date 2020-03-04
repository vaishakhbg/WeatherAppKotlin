package com.comviva.kotlinweather.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.ArrayList


data class WeatherModel(

    @SerializedName("name")
    var name: String = "",

    @SerializedName("coord")
    var coord: Coord? = null,

    @SerializedName("weather")
    var weather: ArrayList<Weather> = ArrayList<Weather>(),

    @SerializedName("main")
    var main: Main? = null

) : Serializable



data class Coord(
    @SerializedName("lat")
    var lat: String = "0.0",

    @SerializedName("lon")
    var lon: String = "0.0"
) : Serializable


data class Weather(


    @SerializedName("description")
    var description: String = ""



) : Serializable



data class Main(
    @SerializedName("temp")
    var temp: String = "0.0",

    @SerializedName("humidity")
    var humidity: String = "0.0"



) : Serializable