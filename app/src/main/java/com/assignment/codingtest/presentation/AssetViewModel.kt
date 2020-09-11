package com.assignment.codingtest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.codingtest.data.Model.AssetList
import com.assignment.codingtest.Usescase.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class AssetViewModel @Inject constructor(private val getAssetUseCaseImpl: GetAssetUseCaseImpl): ViewModel() {
    private val assetMutableList = MutableLiveData<Response<AssetList, Throwable>>()
    fun getCountryDetailsObservable(): LiveData<Response<AssetList, Throwable>> {
        return assetMutableList
    }
    init {
        loadAssetData()
    }

     fun loadAssetData() {
        viewModelScope.launch {
            try {
                assetMutableList.value = SuccessResponse(getAssetUseCaseImpl.execute())
            }catch (throwable : Throwable){
                assetMutableList.value = ErrorResponse(throwable)

            }
        }
    }

}