package com.seenu.weatherapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seenu.weatherapp.presentation.TestScreen
import com.seenu.weatherapp.presentation.searchScreen.SearchScreen
import com.seenu.weatherapp.util.NavRoutes

@Composable
fun RootApp(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.MAIN_SCREEN
    ){
        composable(
            route = NavRoutes.MAIN_SCREEN
        ) {
            TestScreen(navController = navController)
        }
        composable(
            route = NavRoutes.SEARCH_SCREEN
        ) {
            SearchScreen()
        }
    }
}