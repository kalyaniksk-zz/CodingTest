package com.assignment.codingtest.Services

import com.assignment.codingtest.data.Model.AssetList
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("1/coding_test/13ZZQX/full")
    fun getData(): Deferred<AssetList>
}