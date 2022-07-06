package com.lebedaliv2601.tampaexplorer.presentation.screens.game_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lebedaliv2601.tampaexplorer.domain.usecase.GetGameInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class GameInfoViewModel @Inject constructor(
    private val getGameInfoUseCase: GetGameInfoUseCase
) : ViewModel(){

    private val _uiState = MutableStateFlow<GameInfoUIState>(GameInfoUIState.StartLoading)
    val uiState = _uiState.asStateFlow()

    fun getGameInfo(gameId: Long){
        viewModelScope.launch {

            _uiState.value = GameInfoUIState.Loading
            _uiState.value = withContext(Dispatchers.IO){
                try {
                    GameInfoUIState.Success(data = getGameInfoUseCase.invoke(gameId))
                } catch (e: Exception){
                    GameInfoUIState.Error(e.message ?: "Error")
                }
            }

        }

    }

}