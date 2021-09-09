package com.reubencoutinho.newsapp.latestnews.model.api

import com.reubencoutinho.newsapp.latestnews.model.model.LatestNewsModel
import retrofit2.Response
import retrofit2.http.GET

interface LatestNewsApi {


        @GET("top-headlines?apiKey=95c4ed43f7644dc8a05175665cd04b7a&country=us")
        suspend fun getLatestNewsData(): Response<LatestNewsModel>


}