package com.seenu.weatherapp.data.repository

import android.util.Log
import com.seenu.weatherapp.BuildConfig
import com.seenu.weatherapp.data.api.WeatherApi
import com.seenu.weatherapp.data.mappers.toDomain
import com.seenu.weatherapp.domain.model.search_item.SearchResult
import com.seenu.weatherapp.domain.model.weather_report.CurrentWeatherReport
import com.seenu.weatherapp.domain.repository.WeatherRepository
import com.seenu.weatherapp.util.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class WeatherRepositoryImplementation @Inject constructor(
    private val api : WeatherApi
) : WeatherRepository {
    override suspend fun getCurrentWeather(): Flow<Resources<CurrentWeatherReport>> {
        return flow {
            emit(Resources.Loading())
            try {
                val ipLookup = api.ipLookUp(BuildConfig.API_KEY)
                Log.d("ipLookup","$ipLookup")
                val response = api.getCurrentWeather(
                    apiKey = BuildConfig.API_KEY,
                    query = ipLookup.ip?:"wrong ip",
                    aqi = "yes"
                )
                Log.d("CURRENT WEATHER DT)","$response")
                emit(Resources.Success(response.toDomain()))
                Log.d("CURRENT WEATHER DOMAIN","${response.toDomain()}")
            }catch (e : HttpException){
                emit(Resources.Error(message = e.message()))
            }catch (e : IOException){
                emit(Resources.Error(message = e.message?:"Unknown Error"))
            }
        }
    }

    override suspend fun searchByCity(city: String): Flow<Resources<List<SearchResult>>> {
        return flow {
            emit(Resources.Loading())
            try {
                val response = api.searchLocation(
                    apiKey = BuildConfig.API_KEY,
                    query = city
                )
                Log.d("Search Response","$response")
                emit(Resources.Success(response.map { it.toDomain() }))
                Log.d("SEARCH RESULT DOMAIN","${response.map { it.toDomain() }}")
            }catch (e : HttpException){
                emit(Resources.Error(message = e.message()))
            }
            catch (e : IOException){
                emit(Resources.Error(message = e.message?:"Unknown Error"))
            }
        }
    }
}