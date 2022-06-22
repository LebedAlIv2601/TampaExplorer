package com.lebedaliv2601.tampaexplorer.data.repository

import android.util.Log
import com.lebedaliv2601.tampaexplorer.data.mappers.toGameModelList
import com.lebedaliv2601.tampaexplorer.data.network.NHLApi
import com.lebedaliv2601.tampaexplorer.domain.model.GameModel
import com.lebedaliv2601.tampaexplorer.domain.repository.GetGamesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetGamesRepositoryImpl @Inject constructor(private val nhlApi: NHLApi) : GetGamesRepository{

    override suspend fun getGames(season: String, seasonType: String): Flow<List<GameModel>> {
        return nhlApi.getGames(season, seasonType).map { it.toGameModelList().reversed()}
    }

}