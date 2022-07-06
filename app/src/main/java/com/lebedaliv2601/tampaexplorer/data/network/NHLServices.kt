package com.lebedaliv2601.tampaexplorer.data.network

import com.lebedaliv2601.tampaexplorer.data.model.GameInfoModelData
import com.lebedaliv2601.tampaexplorer.data.model.GamesModelData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NHLServices {

    @GET("schedule?teamId=14")
    suspend fun getGames(
        @Query("season") season: String,
        @Query("gameType") seasonType: String
    ): GamesModelData

    @GET("game/{gameId}/feed/live")
    suspend fun getGameInfo(
        @Path("gameId") gameId: Long
    ): GameInfoModelData

}