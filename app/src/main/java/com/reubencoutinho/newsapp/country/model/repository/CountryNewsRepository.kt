package com.reubencoutinho.newsapp.country.model.repository

import com.reubencoutinho.newsapp.country.model.api.CountryNewsService


class CountryNewsRepository(private val countryNews: CountryNewsService) {
    suspend fun getUserData()= countryNews.getCountryNewsService().getCountryNewsData()
}