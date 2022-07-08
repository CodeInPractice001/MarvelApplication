package com.example.marvelapp.api


import com.example.marvelapp.model.MarvelModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody
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


    @Mock
    lateinit var apiService: MarvelApiService
    //private val repositoryImp: MarvelRepositoryImp = Mockito.mock(MarvelRepositoryImp::class.java)
    @Mock
    lateinit var repositoryImp:MarvelRepositoryImp




    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
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

    @Test
    fun getErrorIfListDoesNotGetUploaded(){
        runBlocking {
            Mockito.`when`(apiService.getAllLists()).thenReturn(Response.error(404,null))
        //    val response = apiService.getAllLists()
            val response = listOf<MarvelModel>()
            assertEquals("",response)
        }
    }
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }
}