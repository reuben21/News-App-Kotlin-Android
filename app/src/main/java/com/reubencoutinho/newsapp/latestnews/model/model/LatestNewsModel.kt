package com.reubencoutinho.newsapp.latestnews.model.model

data class LatestNewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)