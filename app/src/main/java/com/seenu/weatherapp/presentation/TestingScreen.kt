package com.seenu.weatherapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.seenu.weatherapp.domain.model.weather_report.CurrentWeatherReport
import com.seenu.weatherapp.domain.uistate.WeatherState

@Composable
fun TestScreen(
    viewModel : TestingViewModel = hiltViewModel()
){
    val state = viewModel.weatherState.value

    when(state){
        is WeatherState.IsLoading -> {
            LoadingScreen()
        }
        is WeatherState.Success -> {
            HomeScreen(state.value)
        }
        is WeatherState.Error -> {
            ErrorScreen(state.value)
        }
        else -> {
            Text(text = "hello android.")
        }
    }
}

@Composable
fun LoadingScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun HomeScreen(weatherReport : CurrentWeatherReport?){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(0.94f).padding(5.dp),
            shape = RoundedCornerShape(15.dp),
            shadowElevation = 14.dp,
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(9.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = weatherReport?.location?.name ?: "Empty_City")
                AsyncImage(
                    model = "https://${weatherReport?.current?.condition?.icon}",
                    contentDescription = "weather icon",
                    modifier = Modifier.padding(10.dp).clip(CircleShape).size(40.dp),
                )
            }
        }
    }
}

@Composable
fun ErrorScreen(errorMessage : String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = errorMessage ?: "Unknown error")
    }
}