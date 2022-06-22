package com.lebedaliv2601.tampaexplorer.data.network

import com.lebedaliv2601.tampaexplorer.data.model.GamesModelData
import javax.inject.Inject

class NHLRemoteDataSource @Inject constructor(private val services: NHLServices) {

    suspend fun getGames(season: String, seasonType: String): GamesModelData{
        return services.getGames(season, seasonType)
    }

}