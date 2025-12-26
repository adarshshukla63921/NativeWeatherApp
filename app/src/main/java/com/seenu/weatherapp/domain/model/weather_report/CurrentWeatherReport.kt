package com.seenu.weatherapp.domain.model.weather_report

data class CurrentWeatherReport(
    val location: Location,
    val current: Current
)
