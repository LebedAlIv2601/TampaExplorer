package com.lebedaliv2601.tampaexplorer.presentation.screens.game_info

import com.lebedaliv2601.tampaexplorer.domain.model.GameInfoModel

sealed class GameInfoUIState{

    class Success(val data: GameInfoModel): GameInfoUIState()

    class Error(val message: String) : GameInfoUIState()

    object Loading : GameInfoUIState()

    object StartLoading : GameInfoUIState()
}
