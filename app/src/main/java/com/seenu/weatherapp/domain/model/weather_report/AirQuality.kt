package com.seenu.weatherapp.domain.model.weather_report

data class AirQuality(
    val pm25 : Double,
    val pm10 : Double,
    val usEpaIndex : Int
)
