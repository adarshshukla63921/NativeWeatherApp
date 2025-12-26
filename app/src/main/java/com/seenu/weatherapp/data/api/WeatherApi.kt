package com.seenu.weatherapp.data.api

import com.seenu.weatherapp.data.dto.currentweather.CurrentWeatherResponse
import com.seenu.weatherapp.data.dto.searchresult.SearchResultDto
import com.seenu.weatherapp.data.dto.ipLookup.IPLookupDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey : String,
        @Query("q") query : String,
        @Query("aqi") aqi : String = "yes"
    ) : CurrentWeatherResponse


    @GET("v1/ip.json")
    suspend fun ipLookUp(
        @Query("key") apiKey: String
    ) : IPLookupDto

    @GET("v1/search.json")
    suspend fun searchLocation(
        @Query("key") apiKey: String,
        @Query("q") query: Query
    ) : List<SearchResultDto>
}