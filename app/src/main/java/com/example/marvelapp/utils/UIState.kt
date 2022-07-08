package com.example.marvelapp.utils



sealed class Response<T>(val data:T?= null, val errorMsg:String?=null){
    class Loading<T> :Response<T>()
    class Success<T>(data:T?=null):Response<T>(data= data)
    class Error<T>(errorMsg:String):Response<T>(errorMsg=errorMsg)

}
//
//sealed class UIState(){
//    object Loading:UIState()
//    class Success<T>(response:T?=null):UIState()
//    class Error(errorMsg: Exception):UIState()
//}
