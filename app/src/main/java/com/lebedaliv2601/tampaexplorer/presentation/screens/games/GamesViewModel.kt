package com.lebedaliv2601.tampaexplorer.presentation.screens.games


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lebedaliv2601.tampaexplorer.domain.usecase.GetGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase
) : ViewModel() {

    private val _gamesList =
        MutableStateFlow<GamesScreenUiState>(GamesScreenUiState.Loading)
    val gamesList = _gamesList.asStateFlow()

    init {
        getGames("20212022", "R")
    }

    fun getGames(season: String, seasonType: String) {
        viewModelScope.launch {
            _gamesList.value = GamesScreenUiState.Loading
            _gamesList.value = getGamesUseCaseExecuting(season, seasonType)
        }
    }

    private suspend fun getGamesUseCaseExecuting(season: String, seasonType: String): GamesScreenUiState{
        return withContext(Dispatchers.IO){
            try {
                 GamesScreenUiState.Success(
                    data = getGamesUseCase.execute(
                        season = season,
                        seasonType = seasonType
                    )
                )
            } catch (e: Exception) {
                GamesScreenUiState.Error(message = e.message ?: "Some error")
            }
        }
    }

}