package com.seenu.weatherapp.domain.uistate

import com.seenu.weatherapp.domain.model.search_item.SearchResult

sealed class SearchState{
    data class IsLoading(val value : Boolean) : SearchState()
    data class Success(val data : List<SearchResult>) : SearchState()
    data class Error(val value : String) : SearchState()
}


