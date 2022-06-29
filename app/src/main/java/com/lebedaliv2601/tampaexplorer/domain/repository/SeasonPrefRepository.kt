package com.lebedaliv2601.tampaexplorer.domain.repository

import com.lebedaliv2601.tampaexplorer.domain.model.SeasonModel

interface SeasonPrefRepository {

    suspend fun getSeasonFromPref(): SeasonModel

    suspend fun saveSeasonToPref(season: SeasonModel)

}