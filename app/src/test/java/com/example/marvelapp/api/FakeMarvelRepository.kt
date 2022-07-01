package com.example.marvelapp.api

import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.model.MarvelDataModel
import com.example.marvelapp.model.ResultModel
import com.example.marvelapp.utils.Response


class FakeMarvelRepository {
    private val marvelDataModel =MarvelDataModel()
    private val marvelLiveData = MutableLiveData<MarvelDataModel>(marvelDataModel)
    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value:Boolean){
        shouldReturnNetworkError = value
    }

    fun marvelList():Response<MarvelDataModel>{
        return if(shouldReturnNetworkError){
            Response.Error("Error Occurred!")
        }else{
            marvelLiveData.postValue(marvelDataModel)
            Response.Success(marvelDataModel)
        }
    }
}