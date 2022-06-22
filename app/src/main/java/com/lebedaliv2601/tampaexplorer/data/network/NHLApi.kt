package com.lebedaliv2601.tampaexplorer.data.network

import android.util.Log
import com.lebedaliv2601.tampaexplorer.data.model.GamesModelData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NHLApi @Inject constructor(private val services: NHLServices) {

    suspend fun getGames(season: String, seasonType: String): Flow<GamesModelData>{
        Log.e("getGames", "Api")
        return withContext(Dispatchers.IO){
            flow{
                emit(services.getGames(season, seasonType))
            }
        }

    }

}