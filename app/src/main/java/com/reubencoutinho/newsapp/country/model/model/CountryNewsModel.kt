package com.reubencoutinho.newsapp.country.model.model

data class CountryNewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)