package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import com.lebedaliv2601.tampaexplorer.domain.model.GameModel

sealed class GamesScreenUiState {

    class Success(val data: List<GameModel>): GamesScreenUiState()

    class Error(val message: String): GamesScreenUiState()

    object Loading : GamesScreenUiState()

}
