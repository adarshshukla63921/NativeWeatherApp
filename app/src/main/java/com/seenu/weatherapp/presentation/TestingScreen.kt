package com.seenu.weatherapp.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.seenu.weatherapp.domain.model.weather_report.CurrentWeatherReport
import com.seenu.weatherapp.domain.uistate.WeatherState
import com.seenu.weatherapp.util.NavRoutes
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestScreen(
    viewModel : TestingViewModel = hiltViewModel(),
    navController: NavController
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Weather App")
                },
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate(NavRoutes.SEARCH_SCREEN)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            when(val state = viewModel.weatherState.value){
                is WeatherState.IsLoading -> {
                    LoadingScreen()
                }
                is WeatherState.Success -> {
                    HomeScreen(weatherReport = state.value)
                }
                is WeatherState.Error -> {
                    ErrorScreen(state.value)
                }
                else -> {
                    Text(text = "hello android.")
                }
            }
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
        //verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(0.94f).padding(5.dp),
            shape = RoundedCornerShape(15.dp),
            shadowElevation = 14.dp,
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column{
                        Text(text = "${weatherReport?.location?.name} , ${weatherReport?.location?.country}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold)

                        Text(text = "${LocalDateTime.now().dayOfWeek.getDisplayName(
                            TextStyle.FULL,
                            Locale.ENGLISH
                        )} ,${LocalDateTime.now().format(
                            DateTimeFormatter.ofPattern("dd MMM")
                        )}")
                    }
                    AsyncImage(
                        model = "https://${weatherReport?.current?.condition?.icon}",
                        contentDescription = "weather icon",
                        modifier = Modifier.padding(10.dp).clip(CircleShape).size(80.dp),
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth().padding(4.dp)
                ) {
                    // temp
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "${weatherReport?.current?.tempC}°C",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold)
                    }
                    // condition
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    ) {
                        Surface(
                            modifier = Modifier.fillMaxWidth().width(75.dp).padding(10.dp),
                            shape = RoundedCornerShape(15.dp),
                            tonalElevation = 4.dp,
                            border = BorderStroke(4.dp, MaterialTheme.colorScheme.surfaceVariant)

                        ) {
                            Row(
                                modifier = Modifier.padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier.padding(8.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Humidity")
                                    Text(text = "${weatherReport?.current?.humidity ?:""} %")
                                }

                                Column(
                                    modifier = Modifier.padding(8.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Air Quality")
                                    Text(text = "${weatherReport?.current?.airQuality?.pm25 ?:""}μg/m3")
                                }

                                Column(
                                    modifier = Modifier.padding(8.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Wind")
                                    Text(text = "${weatherReport?.current?.windKmph ?:""} km/hr")
                                }
                            }
                        }
                    }
                }
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