package com.seenu.weatherapp.domain.repository

import com.seenu.weatherapp.domain.model.search_item.SearchResult
import com.seenu.weatherapp.domain.model.weather_report.CurrentWeatherReport
import com.seenu.weatherapp.util.Resources
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getCurrentWeather() : Flow<Resources<CurrentWeatherReport>>
    suspend fun searchByCity(city : String) : Flow<Resources<List<SearchResult>>>
}