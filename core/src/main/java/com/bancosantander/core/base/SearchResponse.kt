package com.bancosantander.core.base

data class SearchResponse<T> (
    val resultCount: Int,
    val results: List<T>
)

