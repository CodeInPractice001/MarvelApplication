package com.example.marvelapp.api

import com.google.gson.Gson
import junit.framework.TestCase.assertEquals

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var apiService:MarvelApiService
    lateinit var gson: Gson

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        gson = Gson()
        mockWebServer = MockWebServer()
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(MarvelApiService::class.java)
    }


//    @Test
//    fun `get all movie api test`() {
//        runBlocking {
//             val mockResponse = MockResponse()
//            mockWebServer.enqueue(mockResponse.setBody("[]"))
//            val response = apiService.getAllLists()
//            val request = mockWebServer.takeRequest()
//            assertEquals("/movielist.json",request.path)
//            assertEquals(true, response.body() == null)
//        }
//    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

}