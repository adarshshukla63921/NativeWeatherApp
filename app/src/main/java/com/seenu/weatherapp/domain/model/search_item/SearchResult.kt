package com.seenu.weatherapp.domain.model.search_item

data class SearchResult(
    val name : String,
    val country : String,
    val region : String,
    val lat : Double,
    val lon : Double
)
