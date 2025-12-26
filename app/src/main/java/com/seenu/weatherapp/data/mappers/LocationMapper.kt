package com.seenu.weatherapp.data.mappers

import com.seenu.weatherapp.data.dto.currentweather.LocationDto
import com.seenu.weatherapp.domain.model.weather_report.Location

fun LocationDto.toDomain() : Location{
    return Location(
        name = name?:"",
        region = region?:"",
        country = country?:"",
        lat = lat?:0.0,
        lon = lon?:0.0
    )
}