package com.seenu.weatherapp.data.mappers

import com.seenu.weatherapp.data.dto.currentweather.CurrentWeatherDto
import com.seenu.weatherapp.domain.model.weather_report.CurrentWeatherReport

fun CurrentWeatherDto.toDomain() : CurrentWeatherReport{
    return CurrentWeatherReport(
        location = locationDto?.toDomain()?:throw Exception("Missing Data"),
        current = currentDto?.toDomain()?:throw Exception("Missing Data")
    )
}