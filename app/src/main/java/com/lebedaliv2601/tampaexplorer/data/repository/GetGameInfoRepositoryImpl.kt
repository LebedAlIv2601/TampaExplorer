package com.lebedaliv2601.tampaexplorer.data.repository

import com.lebedaliv2601.tampaexplorer.data.mappers.toDomain
import com.lebedaliv2601.tampaexplorer.data.network.NHLRemoteDataSource
import com.lebedaliv2601.tampaexplorer.domain.model.GameInfoModel
import com.lebedaliv2601.tampaexplorer.domain.repository.GetGameInfoRepository
import javax.inject.Inject

class GetGameInfoRepositoryImpl @Inject constructor(private val nhlDataSource: NHLRemoteDataSource) :
    GetGameInfoRepository {

    override suspend fun getGameInfo(gameId: Long): GameInfoModel {
        return nhlDataSource.getGameInfo(gameId = gameId).toDomain()
    }

}