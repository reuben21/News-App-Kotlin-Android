package com.reubencoutinho.newsapp.latestnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reubencoutinho.newsapp.latestnews.model.api.LatestNewsService
import com.reubencoutinho.newsapp.latestnews.model.model.LatestNewsModel
import com.reubencoutinho.newsapp.latestnews.model.repository.LatestNewsRepository
import com.reubencoutinho.newsapp.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LatestNewsViewModel:ViewModel() {

    private val repository: LatestNewsRepository = LatestNewsRepository(LatestNewsService(
        RetrofitBuilder
    ))

    private var _latestNewsLiveData = MutableLiveData<LatestNewsModel>()

    val latestNewsLiveData: LiveData<LatestNewsModel> get() = _latestNewsLiveData

    //passing data b/w fragments
    val passingData=MutableLiveData<String>("")



    fun fetchData(){

        viewModelScope.launch(Dispatchers.IO) {

            val response = repository.getUserData()

            if(response.isSuccessful){

                _latestNewsLiveData.postValue(response.body())
            }

        }
    }


    fun setData(name:String){
        passingData.value = name

    }
}