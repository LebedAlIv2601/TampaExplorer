package com.lebedaliv2601.tampaexplorer.domain.repository

import com.lebedaliv2601.tampaexplorer.domain.model.GameModel

interface GetGamesRepository {

    suspend fun getGames(season: String, seasonType: String): List<GameModel>

}