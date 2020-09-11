package com.assignment.codingtest

import com.assignment.codingtest.data.Model.Asset
import com.assignment.codingtest.data.Model.AssetList

object TestData {


    fun getRepositories(): AssetList {
        val asset = Asset("test", "test", "cxc", "www.googl.com" ,"1599737580000")

        val assetList = AssetList("ABC", listOf(asset))

        return  assetList;
    }

}