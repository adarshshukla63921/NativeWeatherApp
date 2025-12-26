package com.seenu.weatherapp.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seenu.weatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TestingViewModel @Inject constructor(
    private val repo : WeatherRepository
) : ViewModel() {

    fun justRunIt(){
        viewModelScope.launch {
            repo.getCurrentWeather().collect {  }
            repo.searchByCity("Delhi").collect {  }
        }
    }
}