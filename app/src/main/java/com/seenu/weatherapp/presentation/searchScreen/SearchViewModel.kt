package com.seenu.weatherapp.presentation.searchScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seenu.weatherapp.domain.repository.WeatherRepository
import com.seenu.weatherapp.domain.uistate.SearchState
import com.seenu.weatherapp.util.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    var searchCity by mutableStateOf("")
    val searchState = mutableStateOf<SearchState?>(null)
    fun searchCityByString(city : String){
        viewModelScope.launch {
            delay(1500)
            repository.searchByCity(city).collect {
                state ->
                searchState.value = SearchState.IsLoading(value = true)
                when(state){
                    is Resources.Success -> {
                        searchState.value = SearchState.IsLoading(value = false)
                        searchState.value = SearchState.Success(
                            state.data ?: emptyList()
                        )
                    }
                    is Resources.Loading -> {
                        searchState.value = SearchState.IsLoading(value = true)
                    }
                    is Resources.Error -> {
                        searchState.value = SearchState.IsLoading(value = false)
                        searchState.value = SearchState.Error(
                            state.message ?: "Unknown Error"
                        )
                    }
                }
            }
        }
    }
}