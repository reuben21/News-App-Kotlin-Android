package com.reubencoutinho.newsapp.latestnews.model.api
import com.reubencoutinho.newsapp.network.RetrofitBuilder

class LatestNewsService (private val retrofitBuilder: RetrofitBuilder){

    fun getLatestNewsService(): LatestNewsApi = retrofitBuilder.retrofit.create(LatestNewsApi::class.java)

}