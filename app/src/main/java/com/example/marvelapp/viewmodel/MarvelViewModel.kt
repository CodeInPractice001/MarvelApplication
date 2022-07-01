package com.example.marvelapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.marvelapp.api.MarvelRepositoryImp
import com.example.marvelapp.model.MarvelDataModel
import com.example.marvelapp.model.MarvelModel
import com.example.marvelapp.utils.Response

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarvelViewModel @Inject constructor(
    private val repository: MarvelRepositoryImp
    ): ViewModel() {

     val marvelLiveData: LiveData<Response<MarvelModel>> get() = repository.marvelData


    init {
        fetchMarvels()
    }

    private fun fetchMarvels() {
       viewModelScope.launch {
            repository.fetchMarvelList()

            }
        }
    }


