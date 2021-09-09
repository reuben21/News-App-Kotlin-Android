package com.reubencoutinho.newsapp.latestnews.model.repository

import com.reubencoutinho.newsapp.latestnews.model.api.LatestNewsService

class LatestNewsRepository(private val latestNews: LatestNewsService) {

    suspend fun getUserData()= latestNews.getLatestNewsService().getLatestNewsData()

}