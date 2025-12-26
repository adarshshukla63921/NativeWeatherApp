package com.seenu.weatherapp.data.dto.currentweather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class CurrentWeatherDto(
    @field:Json(name = "location") val locationDto: LocationDto?,
    @field:Json(name = "current") val currentDto : CurrentDto?
)