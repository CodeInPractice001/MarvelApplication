package com.example.marvelapp.api


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.marvelapp.getOrAwait
import com.example.marvelapp.model.MarvelDataModel
import com.example.marvelapp.model.MarvelModel
import com.example.marvelapp.model.ResultModel
import com.example.marvelapp.viewmodel.MarvelViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import retrofit2.Response

@RunWith(JUnit4::class)
class MarvelRepositoryImpTest {


    @Rule
    @JvmField
    var initRule: MockitoRule = MockitoJUnit.rule()




    private val dispatcher = TestCoroutineDispatcher()


    @Mock
    lateinit var apiService: MarvelApiService
    //private val repositoryImp: MarvelRepositoryImp = Mockito.mock(MarvelRepositoryImp::class.java)
    @Mock
    lateinit var repositoryImp:MarvelRepositoryImp




    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockitoAnnotations.openMocks(this)

        repositoryImp = MarvelRepositoryImp(apiService)

    }



    @Test
    fun `get all movie test`() {
        runBlocking {
            Mockito.`when`(apiService.getAllLists()).thenReturn(Response.success(MarvelModel()))
           val response = apiService.getAllLists()
            assertEquals(MarvelModel(),response.body())
        }
    }
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }
}