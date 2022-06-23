package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import com.lebedaliv2601.tampaexplorer.domain.model.GameModel

sealed class GamesListUiState {

    class Success(val data: List<GameModel>): GamesListUiState()

    class Error(val message: String): GamesListUiState()

    object Loading : GamesListUiState()

}
