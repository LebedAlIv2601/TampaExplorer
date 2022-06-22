package com.lebedaliv2601.tampaexplorer.domain.repository

import com.lebedaliv2601.tampaexplorer.domain.model.GameModel
import kotlinx.coroutines.flow.Flow

interface GetGamesRepository {

    suspend fun getGames(season: String, seasonType: String): Flow<List<GameModel>>

}