package com.example.marvelapp.utils

import com.example.marvelapp.model.MarvelDataModel
import com.example.marvelapp.model.ResultModel

sealed class Response<T>(val data:T?= null, val errorMsg:String?=null){
    class Loading<T>():Response<T>()
    class Success<T>(data:T?=null):Response<T>(data= data)
    class Error<T>(errorMsg:String):Response<T>(errorMsg=errorMsg)

}
