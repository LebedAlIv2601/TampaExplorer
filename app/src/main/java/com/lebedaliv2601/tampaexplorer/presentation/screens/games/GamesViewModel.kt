package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lebedaliv2601.tampaexplorer.domain.model.GameModel
import com.lebedaliv2601.tampaexplorer.domain.usecase.GetGamesUseCase
import com.lebedaliv2601.tampaexplorer.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
   private val getGamesUseCase: GetGamesUseCase
): ViewModel() {

    private val _gamesList = MutableStateFlow<UiState<List<GameModel>>>(UiState.Loading(data = null))
    val gamesList: StateFlow<UiState<List<GameModel>>> get() = _gamesList

    init {
        getGames("20212022", "R")
    }

    fun getGames(season: String, seasonType: String){
        viewModelScope.launch {
            Log.e("getGames", "Start with ${season}")
            _gamesList.value = UiState.Loading(data = null)
            try {
                Log.e("getGames", "Execute")
                getGamesUseCase.execute(season = season, seasonType = seasonType).collect{
                    Log.e("getGames", it.toString())
                    _gamesList.value = UiState.Success(data = it)
                    Log.e("getGames", "Success")
                }
            } catch (e: Exception){
                _gamesList.value = UiState.Error(data = null,  message = e.message)
                Log.e("getGames", "Error")

            }
//            getGamesUseCaseExecuting(season, seasonType)
        }
    }

//    private suspend fun getGamesUseCaseExecuting(season: String, seasonType: String){
//        withContext(Dispatchers.IO){
//
//        }
//    }


}