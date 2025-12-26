package com.seenu.weatherapp.data.dto.ipLookup

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IPLookupDto(
    @field:Json(name = "ip") val ip : String? = "",
    @field:Json(name = "type") val type : String? = "",
    @field:Json(name = "continent_code") val continentCode : String? = "",
    @field:Json(name = "continent_name") val continentName : String? = "",
    @field:Json(name = "country_code") val countryCode : String? = "",
    @field:Json(name = "country_name") val countryName : String? = "",
    @field:Json(name = "is_eu") val isEu : String? = "false",
    @field:Json(name = "geoname_id") val geonameID : Long? = 0,
    @field:Json(name = "city") val city : String? = "",
    @field:Json(name = "region") val region : String? ="",
    @field:Json(name = "lat") val lat : Double? = 0.0,
    @field:Json(name = "lon") val lon : Double? = 0.0,
    @field:Json(name = "tz_id") val tzID : String? = "",
)