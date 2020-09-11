package com.assignment.codingtest.respository

import com.assignment.codingtest.data.Model.AssetList
import com.assignment.codingtest.Services.ApiService


class AssetDataRepo @javax.inject.Inject constructor(private val apiService: ApiService) {

        suspend fun getAssetsDetails(): AssetList {
            val job = apiService.getData()
            var countryDetails = job?.await()
            return countryDetails

        }

    }
