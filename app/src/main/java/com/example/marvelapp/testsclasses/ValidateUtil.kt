package com.example.marvelapp.testsclasses

import com.example.marvelapp.model.MarvelDataModel
import com.example.marvelapp.model.ResultModel
import com.example.marvelapp.utils.Response


object ValidateUtil{
 fun <T> ValidateState(response: Response<T>):Boolean{
        when(response){
            is Response.Success->return true
            is Response.Error->return false
            is Response.Loading->return true
        }
    }
}