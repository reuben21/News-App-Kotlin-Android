package com.reubencoutinho.newsapp.country.model.api

import com.reubencoutinho.newsapp.country.model.model.CountryNewsModel
import retrofit2.Response
import retrofit2.http.GET

interface CountryNewsApi {


    @GET("top-headlines?country=in&apiKey=95c4ed43f7644dc8a05175665cd04b7a")
    suspend fun getCountryNewsData(): Response<CountryNewsModel>
}