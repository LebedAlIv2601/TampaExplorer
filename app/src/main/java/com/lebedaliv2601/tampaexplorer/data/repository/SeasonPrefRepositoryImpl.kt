package com.lebedaliv2601.tampaexplorer.data.repository

import com.lebedaliv2601.tampaexplorer.data.local.SeasonPrefManager
import com.lebedaliv2601.tampaexplorer.data.mappers.toData
import com.lebedaliv2601.tampaexplorer.data.mappers.toDomain
import com.lebedaliv2601.tampaexplorer.domain.model.SeasonModel
import com.lebedaliv2601.tampaexplorer.domain.repository.SeasonPrefRepository
import javax.inject.Inject

class SeasonPrefRepositoryImpl @Inject constructor(
    private val seasonPrefManager: SeasonPrefManager
) : SeasonPrefRepository {

    @ExperimentalStdlibApi
    override suspend fun getSeasonFromPref(): SeasonModel {
        return seasonPrefManager.getSeasonFromPref().toDomain()
    }

    @ExperimentalStdlibApi
    override suspend fun saveSeasonToPref(season: SeasonModel) {
        seasonPrefManager.saveSeasonToPref(season.toData())
    }
}