package com.lebedaliv2601.tampaexplorer.data.repository

import com.lebedaliv2601.tampaexplorer.data.mappers.toGameModelList
import com.lebedaliv2601.tampaexplorer.data.network.NHLRemoteDataSource
import com.lebedaliv2601.tampaexplorer.domain.model.GameModel
import com.lebedaliv2601.tampaexplorer.domain.repository.GetGamesRepository
import javax.inject.Inject

class GetGamesRepositoryImpl @Inject constructor(private val nhlApi: NHLRemoteDataSource) : GetGamesRepository{

    override suspend fun getGames(season: String, seasonType: String): List<GameModel> {
        return nhlApi.getGames(season, seasonType).toGameModelList().reversed()
    }

}