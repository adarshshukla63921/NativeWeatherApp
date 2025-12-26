package com.seenu.weatherapp.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TestScreen(
    viewModel : TestingViewModel = hiltViewModel()
){
    viewModel.justRunIt()
}
