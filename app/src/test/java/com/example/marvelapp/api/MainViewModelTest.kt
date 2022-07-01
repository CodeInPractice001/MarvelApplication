package com.example.marvelapp.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.marvelapp.getOrAwait
import com.example.marvelapp.viewmodel.MarvelViewModel
import junit.framework.TestCase.assertEquals

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MainViewModelTest {


    private val testDispatcher = TestCoroutineDispatcher()
    lateinit var mainViewModel: MarvelViewModel
   lateinit var  mainRepository: MarvelRepositoryImp

//execute the tasks synchronously(one by one)
    @get:Rule
    val instantTaskExecutionRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
       // mainRepository = MarvelRepositoryImp()
        mainViewModel = MarvelViewModel(mainRepository)
    }

//    @Test
//    fun getAllMoviesTest() {
//        runBlocking {
//            Mockito.`when`(mainRepository.fetchMarvelList())
//                .thenReturn(Response.success(ModelDataModel()))
//            mainViewModel.marvelLiveData.getOrAwait()
//            val result = mainViewModel.movieList.getOrAwaitValue()
//            assertEquals(listOf<Marvel>(Movie("movie", "", "new")), result)
//        }
//    }
//
//
//    @Test
//    fun `empty movie list test`() {
//        runBlocking {
//            Mockito.`when`(mainRepository.getAllMovies())
//                .thenReturn(Response.success(listOf<Movie>()))
//            mainViewModel.getAllMovies()
//            val result = mainViewModel.movieList.getOrAwaitValue()
//            assertEquals(listOf<Movie>(), result)
//        }
//    }

}