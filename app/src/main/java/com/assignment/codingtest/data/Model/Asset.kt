package com.assignment.codingtest.data.Model

import com.squareup.moshi.Json

data class Asset(
    @Json(name = "theAbstract")
    var theAbstract : String,
    @Json(name = "headline")
    var headline: String,
    @Json(name = "byLine")
    var byLine: String,
    @Json(name = "url")
    var url: String,
    @Json(name = "timeStamp")
    var timeStamp: String
)
