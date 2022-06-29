package com.lebedaliv2601.tampaexplorer.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SeasonModelData(

    @Json(name = "season_type")
    val seasonType: String,

    @Json(name = "season_year")
    val seasonYear: String

)
