package com.seenu.weatherapp.data.dto.currentweather

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class CurrentDto(
    @field:Json(name = "last_updated_epoch") val lastUpdateEpoch: Long?,
    @field:Json(name = "last_updated") val lastUpdated: String?="",
    @field:Json(name = "temp_c") val tempC: Double?=0.0,
    @field:Json(name = "temp_f") val tempF: Double?=0.0,
    @field:Json(name = "is_day") val isDay: Int?=0,
    @field:Json(name = "condition") val condition: ConditionDto?,
    @field:Json(name = "wind_mph") val windMph: Double?=0.0,
    @field:Json(name = "wind_kph") val windKph: Double?=0.0,
    @field:Json(name = "wind_degree") val windDegree: Int?=0,
    @field:Json(name = "wind_dir") val windDir: String?="",
    @field:Json(name = "pressure_mb") val pressureMb: Double?=0.0,
    @field:Json(name = "pressure_in") val pressureIn: Double?=0.0,
    @field:Json(name = "precip_mm") val precipMm: Double?=0.0,
    @field:Json(name = "precip_in") val precipIn: Double?=0.0,
    @field:Json(name = "humidity") val humidity: Int?=0,
    @field:Json(name = "cloud") val cloud: Int?=0,
    @field:Json(name = "feelslike_c") val feelsLikeC: Double?=0.0,
    @field:Json(name = "feelslike_f") val feelsLikeF: Double?=0.0,
    @field:Json(name = "windchill_c") val windChillC: Double?=0.0,
    @field:Json(name = "windchill_f")val windChillF: Double?=0.0,
    @field:Json(name = "heatindex_c") val heatIndexC: Double?=0.0,
    @field:Json(name = "heatindex_f")val heatIndexF: Double?=0.0,
    @field:Json(name = "dewpoint_c") val dewPointC: Double?=0.0,
    @field:Json(name = "dewpoint_f") val dewPointF: Double?=0.0,
    @field:Json(name = "vis_km") val visKm: Double?=0.0,
    @field:Json(name = "vis_miles") val visMiles: Double?=0.0,
    @field:Json(name = "uv") val uv: Double?=0.0,
    @field:Json(name = "gust_mph") val gustMph: Double?=0.0,
    @field:Json(name = "gust_kph") val gustKph: Double?=0.0,
    @field:Json(name = "air_quality") val airQuality: AirQualityDto?,
    @field:Json(name = "short_rad") val shortRad: Double?=0.0,
    @field:Json(name = "diff_rad") val diffRad: Double?=0.0,
    @field:Json(name = "dni") val dni: Double?=0.0,
    @field:Json(name = "gti") val gti: Double?=0.0
)

