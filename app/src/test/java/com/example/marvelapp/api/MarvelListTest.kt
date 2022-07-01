package com.example.marvelapp.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.marvelapp.model.MarvelDataModel
import com.example.marvelapp.model.MarvelModel
import com.example.marvelapp.utils.Response
import com.example.marvelapp.viewmodel.MarvelViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class MarvelListTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @MockK
    lateinit var apiService: MarvelApiService

@MockK
    lateinit var repositoryImp: MarvelRepositoryImp

    lateinit var viewModel: MarvelViewModel
    val allLists: List<Response<MarvelDataModel>>? = ArrayList()

    private val mainThreadSurrogate = newSingleThreadContext("MainThread")

    //before class run once before executes all the tests
    //while before execute before every run every test
    @Before
    fun initMocKKAndMainThread() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun `checking that the marvel list have some data`() = runTest {


        intilizeViewModel()
        dataTobePassedandRead()
        listShouldContainDataVarification()
    }


    private fun intilizeViewModel() {

        viewModel = MarvelViewModel(repositoryImp)
    }

    private suspend fun dataTobePassedandRead() {
//fetch the data
    }

    private fun listShouldContainDataVarification() {
        assertNotNull(allLists)
        assertTrue(allLists.isNullOrEmpty())
        var containData = false
        allLists!!.forEach {
            if ((it.data!!.limit != -1) && (it.data!!.count != 0)) {
                containData = true
            }
            assertTrue(containData)
        }


    }

    @Test
    fun `given viewmodelwith live data when populated with marvels heros`() = runTest {
        givenViewModelInitilizedWithMockData()
        whenJSONAreReadAndParsed()
        thenResultShouldContainData()
    }

    private fun givenViewModelInitilizedWithMockData() {
        val marvelDataModel =
            MarvelModel("html", "attribuition", 12, "cvgc", MarvelDataModel(), "etag", "status")
        val marvelDataModel1 = MarvelModel(
            "html1",
            "attribuition1",
            13,
            "cvgc1",
            MarvelDataModel(),
            "etag1",
            "status1"
        )
        coEvery { apiService.getAllLists() } returns marvelDataModel as retrofit2.Response<MarvelModel>

//check list with repository or view model

    }

    private fun whenJSONAreReadAndParsed() {
        viewModel.marvelLiveData
    }

    private fun thenResultShouldContainData() {
        var allList: Response<MarvelModel> = Response.Loading()
        val latch = CountDownLatch(1)
        val observer = object : Observer<Response<MarvelModel>> {
            override fun onChanged(t: Response<MarvelModel>?) {
                if (t != null) {
                    allList = t
                }
                latch.countDown()
                viewModel.marvelLiveData.removeObserver(this)
            }

        }
        viewModel.marvelLiveData.observeForever(observer)
        latch.await(10, TimeUnit.SECONDS)
        assertNotNull(allList)
        listShouldContainDataVarification()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

}