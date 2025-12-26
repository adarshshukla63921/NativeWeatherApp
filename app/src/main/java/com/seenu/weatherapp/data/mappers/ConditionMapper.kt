package com.seenu.weatherapp.data.mappers

import com.seenu.weatherapp.data.dto.currentweather.ConditionDto
import com.seenu.weatherapp.domain.model.weather_report.Condition

fun ConditionDto.toDomain() : Condition{
    return Condition(
        text = text?:"",
        icon = icon?:""
    )
}