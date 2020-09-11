package com.assignment.codingtest.data.Model

import com.squareup.moshi.Json

data class AssetList(
    @Json(name = "displayName")
    var displayName : String,
    @Json(name = "assets")
    var assets: List<Asset>
)