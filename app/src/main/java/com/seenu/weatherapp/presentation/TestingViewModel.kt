package com.seenu.weatherapp.presentation


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seenu.weatherapp.domain.repository.WeatherRepository
import com.seenu.weatherapp.domain.uistate.WeatherState
import com.seenu.weatherapp.util.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TestingViewModel @Inject constructor(
    private val repo : WeatherRepository
) : ViewModel() {
    val weatherState = mutableStateOf<WeatherState?>(null)
    init {
        getWeather()
    }
    fun getWeather(){
        viewModelScope.launch {
            repo.getCurrentWeather().collect { state ->
                weatherState.value = WeatherState.IsLoading(true)
                when(state){
                    is Resources.Success -> {
                        weatherState.value = WeatherState.IsLoading(false)
                        weatherState.value = WeatherState.Success(state.data)
                    }
                    is Resources.Loading -> {
                        weatherState.value = WeatherState.IsLoading(true)
                    }
                    is Resources.Error -> {
                        weatherState.value = WeatherState.IsLoading(false)
                        weatherState.value = WeatherState.Error(state.message?:"Unknown Error")
                    }
                }

            }
        }
    }
}