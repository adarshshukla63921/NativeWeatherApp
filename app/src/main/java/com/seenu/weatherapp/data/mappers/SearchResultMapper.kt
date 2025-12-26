package com.seenu.weatherapp.data.mappers

import com.seenu.weatherapp.data.dto.searchresult.SearchResultDto
import com.seenu.weatherapp.domain.model.search_item.SearchResult

fun SearchResultDto.toDomain() : SearchResult{
    return SearchResult(
        name = name?:"",
        region = region?:"",
        country = country?:"",
        lat = lat?:0.0,
        lon = lon?:0.0
    )
}