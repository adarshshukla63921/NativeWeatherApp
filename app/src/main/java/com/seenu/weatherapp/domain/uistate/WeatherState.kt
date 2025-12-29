package com.seenu.weatherapp.domain.uistate

import com.seenu.weatherapp.domain.model.weather_report.CurrentWeatherReport

sealed class WeatherState {
    data class IsLoading(val value: Boolean) : WeatherState()
    data class Success(val value: CurrentWeatherReport?) : WeatherState()
    data class Error(val value: String) : WeatherState()
}
