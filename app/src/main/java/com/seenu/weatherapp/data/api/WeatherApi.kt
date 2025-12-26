package com.seenu.weatherapp.data.api

import com.seenu.weatherapp.data.dto.currentweather.CurrentWeatherDto
import com.seenu.weatherapp.data.dto.searchresult.SearchResultDto
import com.seenu.weatherapp.data.dto.ipLookup.IPLookupDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey : String,
        @Query("q") query : String,
        @Query("aqi") aqi : String = "yes"
    ) : CurrentWeatherDto


    @GET("ip.json")
    suspend fun ipLookUp(
        @Query("key") apiKey: String,
        @Query("q") query: String = "auto:ip"
    ) : IPLookupDto

    @GET("search.json")
    suspend fun searchLocation(
        @Query("key") apiKey: String,
        @Query("q") query: String
    ) : List<SearchResultDto>
}