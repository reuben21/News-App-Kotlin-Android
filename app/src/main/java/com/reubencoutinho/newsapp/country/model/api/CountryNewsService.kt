package com.reubencoutinho.newsapp.country.model.api;
import com.reubencoutinho.newsapp.network.RetrofitBuilder;

public class CountryNewsService( val retrofitBuilder: RetrofitBuilder) {

    fun getCountryNewsService() : CountryNewsApi = retrofitBuilder.retrofit.create(CountryNewsApi::class.java)

}
