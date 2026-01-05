package com.seenu.weatherapp.domain.model.weather_report

data class Current(
    val tempC : Double,
    val tempF : Double,
    val feelsLikeC : Double,
    val feelsLikeF : Double,
    val humidity : Int,
    val isDay : Boolean,
    val condition: Condition,
    val airQuality: AirQuality,
    val windKmph : Double
)
