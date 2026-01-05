package com.seenu.weatherapp.data.mappers

import com.seenu.weatherapp.data.dto.currentweather.CurrentDto
import com.seenu.weatherapp.domain.model.weather_report.Current


fun CurrentDto.toDomain() : Current {
    return Current(
        tempC = tempC?:0.0,
        tempF = tempF?:0.0,
        feelsLikeC = feelsLikeC?:0.0,
        feelsLikeF = feelsLikeF?:0.0,
        humidity = humidity?:0,
        isDay = (isDay ?: 0) == 1,
        condition = condition?.toDomain()?: throw Exception("Missing Data"),
        airQuality = airQuality?.toDomain()?: throw Exception("Missing Data"),
        windKmph = windKph?:0.0,
    )
}