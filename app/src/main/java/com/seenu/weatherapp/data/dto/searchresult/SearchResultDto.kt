package com.seenu.weatherapp.data.dto.searchresult

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResultDto(
    @field:Json(name = "id") val id : Long? = 0,
    @field:Json(name = "name") val name : String? = "",
    @field:Json(name = "region") val region : String? = "",
    @field:Json(name = "country") val country : String? = "",
    @field:Json(name = "lat") val lat : Double? = 0.0,
    @field:Json(name = "lon") val lon : Double? = 0.0,
    @field:Json(name = "url") val url : String = ""
)