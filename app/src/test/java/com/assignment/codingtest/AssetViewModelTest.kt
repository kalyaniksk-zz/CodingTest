package com.assignment.codingtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.assignment.codingtest.data.Model.AssetList
import com.assignment.codingtest.presentation.AssetViewModel
import com.assignment.codingtest.respository.AssetDataRepo
import com.assignment.codingtest.Usescase.GetAssetUseCaseImpl
import com.assignment.codingtest.Usescase.Response
import com.assignment.codingtest.Usescase.SuccessResponse
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class AssetViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()
    private val getAssetUsecase: GetAssetUseCaseImpl = mock()
    private val assetDataRepo: AssetDataRepo = mock()
    lateinit var assetViewModel: AssetViewModel

    @Before
    fun setup() {
        this.assetViewModel = AssetViewModel(getAssetUsecase)
    }

    @Test
    fun testSuccess() = runBlocking {
        whenever(getAssetUsecase.execute()).thenReturn(TestData.getRepositories())
        val testObserver = LiveDataTestObserver<Response<AssetList, Throwable>>()
        assetViewModel.getCountryDetailsObservable().observeForever(testObserver)
        assetViewModel.loadAssetData()

        /* compared the data with Testdata
        * */
        Assert.assertTrue(testObserver.observedValues.last() is SuccessResponse)

        Assert.assertEquals(testObserver.observedValues.last()?.data?.displayName, TestData.getRepositories().displayName)
    }
}