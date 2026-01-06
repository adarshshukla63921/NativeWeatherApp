package com.seenu.weatherapp.presentation.searchScreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.seenu.weatherapp.domain.model.search_item.SearchResult
import com.seenu.weatherapp.domain.uistate.SearchState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    viewmodel : SearchViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextField(
                        value = viewmodel.searchCity,
                        onValueChange = {
                            viewmodel.searchCity = it
                            viewmodel.searchCityByString(viewmodel.searchCity)
                        },
                        shape = RoundedCornerShape(30.dp)
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            viewmodel.searchCityByString(viewmodel.searchCity)
                        }
                    ){
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
            when(viewmodel.searchState.value){
                is SearchState.IsLoading -> {
                    LoadingScreen()
                }
                is SearchState.Success -> {
                    ResultScreen(resultList = (viewmodel.searchState.value as SearchState.Success).data)
                }
                is SearchState.Error -> {
                    ErrorScreen(error = (viewmodel.searchState.value as SearchState.Error).value)
                }
                else -> {}
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
fun ResultScreen(resultList : List<SearchResult?>){
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        LazyColumn{
            items( resultList){
                searchResult->
                SearchResultCard(searchResult)
            }
        }
    }
}

@Composable
fun SearchResultCard(searchResult : SearchResult?){
    Surface(
        modifier = Modifier.padding(8.dp).fillMaxWidth(0.9f),
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(4.dp)
        ) {
            Text(text = "${searchResult?.name}",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "${searchResult?.country}",
                    modifier = Modifier.padding(8.dp))
                Text(text = "${searchResult?.region}",
                    modifier = Modifier.padding(8.dp))
            }
        }
    }
}


@Composable
fun ErrorScreen(error : String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = error?:"unknown error occurred")
    }
}