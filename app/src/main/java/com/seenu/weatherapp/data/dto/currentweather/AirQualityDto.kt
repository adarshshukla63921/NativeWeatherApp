package com.seenu.weatherapp.data.dto.currentweather

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
@JsonClass(generateAdapter = true)
data class AirQualityDto(
    @field:Json(name = "co2") val co2 : Double? = 0.0,
    @field:Json(name = "no2") val no2 : Double? = 0.0,
    @field:Json(name = "o3") val o3 : Double? = 0.0,
    @field:Json(name = "so2") val so2 : Double? = 0.0,
    @field:Json(name = "pm2_5") val pm25 : Double? = 0.0,
    @field:Json(name = "pm10") val pm10 : Double? = 0.0,
    @field:Json(name = "us-epa-index") val usEpaIndex : Int?=0,
    @field:Json(name = "gb-defra-index") val gbDefraIndex : Int?=0
)
