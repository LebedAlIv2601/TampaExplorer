package com.lebedaliv2601.tampaexplorer.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.lebedaliv2601.tampaexplorer.data.model.SeasonModelData
import com.lebedaliv2601.tampaexplorer.domain.model.SeasonModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import javax.inject.Inject

class SeasonPrefManager @Inject constructor(private val context: Context) {

    private val moshi: Moshi = Moshi.Builder().build()
    @ExperimentalStdlibApi
    private val adapter = moshi.adapter<SeasonModelData>()

    private val prefs = context.getSharedPreferences(SEASON_STORAGE, MODE_PRIVATE)

    @ExperimentalStdlibApi
    suspend fun saveSeasonToPref(seasonModel: SeasonModelData){

        val seasonJson = adapter.toJson(seasonModel)

        val editor = prefs.edit()

        editor.putString(SEASON_STORAGE, seasonJson)

        editor.apply()

    }

    @ExperimentalStdlibApi
    suspend fun getSeasonFromPref(): SeasonModelData{

        val seasonJson = prefs.getString(SEASON_STORAGE, "")

        return if(seasonJson == ""){
            SeasonModelData("P", "2021-2022")
        } else {

            adapter.fromJson(seasonJson) ?: SeasonModelData("P", "2021-2022")

        }

    }

    companion object {
        private const val SEASON_STORAGE = "season"
    }

}