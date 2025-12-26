package com.seenu.weatherapp.data.dto.currentweather

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class ConditionDto(
    @field:Json(name = "text") val text : String? = "",
    @field:Json(name = "icon") val icon : String = "",
    @field:Json(name = "code") val code : Int = 0
)
