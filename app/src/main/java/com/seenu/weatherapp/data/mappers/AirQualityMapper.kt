package com.seenu.weatherapp.data.mappers

import com.seenu.weatherapp.data.dto.currentweather.AirQualityDto
import com.seenu.weatherapp.domain.model.weather_report.AirQuality

fun AirQualityDto.toDomain() : AirQuality{
    return AirQuality(
        pm25 = pm25?:0.0,
        pm10 = pm10?:0.0,
        usEpaIndex = usEpaIndex?:0
    )
}