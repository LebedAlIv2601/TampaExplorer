package com.lebedaliv2601.tampaexplorer.domain.repository

import com.lebedaliv2601.tampaexplorer.domain.model.GameInfoModel
import com.lebedaliv2601.tampaexplorer.domain.model.GameStatsModel

interface GetGameInfoRepository {

    suspend fun getGameInfo(gameId: Long): GameInfoModel

}