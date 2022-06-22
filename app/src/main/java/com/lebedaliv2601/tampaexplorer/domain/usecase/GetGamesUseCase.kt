package com.lebedaliv2601.tampaexplorer.domain.usecase

import com.lebedaliv2601.tampaexplorer.domain.model.GameModel
import com.lebedaliv2601.tampaexplorer.domain.repository.GetGamesRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val repository: GetGamesRepository) {

    suspend fun execute(season: String, seasonType: String): List<GameModel> {
        return repository.getGames(season, seasonType)
    }

}