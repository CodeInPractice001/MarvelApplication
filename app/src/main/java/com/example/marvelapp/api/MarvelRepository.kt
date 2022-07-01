package com.example.marvelapp.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.model.MarvelDataModel
import com.example.marvelapp.model.MarvelModel
import com.example.marvelapp.utils.Response

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject



class MarvelRepositoryImp @Inject constructor(
    private val service: MarvelApiService
) {

    private val _marvelData = MutableLiveData<Response<MarvelModel>>()
    val marvelData: LiveData<Response<MarvelModel>> get() = _marvelData

    suspend fun fetchMarvelList() {
        try{
            val response = service.getAllLists()
            if (response.isSuccessful) {
                _marvelData.postValue(Response.Success(response.body()))
            }else{
                _marvelData.postValue(Response.Error("Error Occurred Network Call"))
            }
        }catch(e :Exception){
        _marvelData.postValue(Response.Error(e.message.toString()))
        }


    }


}


