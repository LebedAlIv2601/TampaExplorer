package com.lebedaliv2601.tampaexplorer.domain.usecase

import com.lebedaliv2601.tampaexplorer.domain.model.GameInfoModel
import com.lebedaliv2601.tampaexplorer.domain.repository.GetGameInfoRepository
import javax.inject.Inject

class GetGameInfoUseCase @Inject constructor(private val repository: GetGameInfoRepository) {

    suspend fun invoke(gameId: Long): GameInfoModel {
        return repository.getGameInfo(gameId)
    }
}