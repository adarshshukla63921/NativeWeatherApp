package com.seenu.weatherapp.domain.model.weather_report

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double
)
