package com.example.marvelapp.api

import com.example.marvelapp.model.MarvelModel
import junit.framework.TestCase.assertEquals


import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@RunWith(JUnit4::class)
class MarvelRepositoryImpTest {
    lateinit var repositoryImp: MarvelRepositoryImp

    @Mock
    lateinit var apiService: MarvelApiService

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        repositoryImp = MarvelRepositoryImp(apiService)
    }

    @Test
    fun `get all movies test`(){
        runBlocking {
            Mockito.`when`(apiService.getAllLists()).thenReturn(Response.success(MarvelModel()))
            val response = repositoryImp.fetchMarvelList()
           assertEquals(listOf<MarvelModel>(), repositoryImp.fetchMarvelList())

}
}
}