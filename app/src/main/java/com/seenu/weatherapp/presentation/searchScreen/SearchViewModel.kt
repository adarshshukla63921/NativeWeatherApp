package com.seenu.weatherapp.presentation.searchScreen

import androidx.lifecycle.ViewModel
import com.seenu.weatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

}