package com.reubencoutinho.newsapp.country.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reubencoutinho.newsapp.country.model.api.CountryNewsService
import com.reubencoutinho.newsapp.country.model.model.CountryNewsModel
import com.reubencoutinho.newsapp.country.model.repository.CountryNewsRepository
import com.reubencoutinho.newsapp.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewModel: ViewModel() {

    private val repository: CountryNewsRepository = CountryNewsRepository(
        CountryNewsService(
        RetrofitBuilder
    )
    )

    private var _countryNewsLiveData = MutableLiveData<CountryNewsModel>()

    val countryNewsLiveData: LiveData<CountryNewsModel> get() = _countryNewsLiveData

    //passing data b/w fragments
    val passingData= MutableLiveData<String>("")



    fun fetchData(){

        viewModelScope.launch(Dispatchers.IO) {

            val response = repository.getUserData()

            if(response.isSuccessful){

                _countryNewsLiveData.postValue(response.body())
            }

        }
    }


    fun setData(name:String){
        passingData.value = name

    }
}