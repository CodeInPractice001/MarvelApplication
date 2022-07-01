package com.example.marvelapp.api



import com.example.marvelapp.utils.MARVEL_API_ENDPOINT
import com.example.marvelapp.model.MarvelDataModel
import com.example.marvelapp.model.MarvelModel


import retrofit2.Response
import retrofit2.http.GET


interface MarvelApiService {
    @GET(MARVEL_API_ENDPOINT)
    suspend fun getAllLists(): Response<MarvelModel>

}