package com.assignment.codingtest.Usescase

import com.assignment.codingtest.data.Model.AssetList
import com.assignment.codingtest.respository.AssetDataRepo
import javax.inject.Inject

sealed class Response<T, E>(open val data: T?)

data class ErrorResponse<T, E> constructor(val errorData: E?, override val data: T? = null) :
    Response<T, E>(data)

data class SuccessResponse<T, E> constructor(override val data: T) : Response<T, E>(data)

interface GetAssetUsecase {
    suspend fun execute(): AssetList
}

class GetAssetUseCaseImpl @Inject constructor (private val assetDataRepo: AssetDataRepo) : GetAssetUsecase {
    override suspend fun execute(): AssetList = assetDataRepo.getAssetsDetails()
}