package com.lebedaliv2601.tampaexplorer.presentation.screens.games


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lebedaliv2601.tampaexplorer.domain.model.GameModel
import com.lebedaliv2601.tampaexplorer.domain.usecase.GetGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase
) : ViewModel() {

    private val _gamesListState =
        MutableStateFlow<GamesListUiState>(GamesListUiState.Loading)
    val gamesListState = _gamesListState.asStateFlow()

    private val _seasonYear =
        MutableStateFlow("2021-2022")
    val seasonYear = _seasonYear.asStateFlow()

    private val _seasonType =
        MutableStateFlow("P")
    val seasonType = _seasonType.asStateFlow()

    private val _seasonSelectorState =
        MutableStateFlow<SeasonSelectorState>(SeasonSelectorState.Invisible)
    val seasonSelectorState = _seasonSelectorState.asStateFlow()

    private var isGamesListNeedsToBeUpdated = true

    init {
        viewModelScope.launch {
            getGamesData().collect {
                if (it is GamesListUiState.SuccessPlayOff
                    || it is GamesListUiState.SuccessRegular
                    || it is GamesListUiState.Error
                ) {
                    isGamesListNeedsToBeUpdated = false
                }
                _gamesListState.value = it
            }
        }
    }

    private fun getGamesData() =
        flow {
            while (true) {
                delay(10)
                if (isGamesListNeedsToBeUpdated
                    && _seasonSelectorState.value is SeasonSelectorState.Invisible
                ) {

                    emit(GamesListUiState.Loading)

                    try {

                        val list = withContext(Dispatchers.IO) {
                            getGamesUseCase.execute(
                                season = _seasonYear.value.replace("-", ""),
                                seasonType = _seasonType.value
                            )
                        }

                        if (_seasonType.value == "P") {
                            emit(
                                GamesListUiState.SuccessPlayOff(
                                    data = list.groupBy { it.gameId.toString().substring(7, 8) }
                                )
                            )
                        } else {
                            emit(
                                GamesListUiState.SuccessRegular(
                                    data = list
                                )
                            )
                        }


                    } catch (e: Exception) {
                        emit(GamesListUiState.Error(message = e.message ?: "Some error"))
                    }
                }
            }

        }


    fun changeSelectorState() {
        if (_seasonSelectorState.value is SeasonSelectorState.Invisible) {
            _seasonSelectorState.value = SeasonSelectorState.Visible(
                _seasonType.value, _seasonYear.value
            )
        } else {
            _seasonSelectorState.value = SeasonSelectorState.Invisible
        }
    }

    fun setSeasonType(seasonType: String) {
        if (_seasonSelectorState.value is SeasonSelectorState.Visible) {
            val currentSeasonVisibleState =
                (_seasonSelectorState.value as SeasonSelectorState.Visible)
            if (currentSeasonVisibleState.seasonType != seasonType) {
                isGamesListNeedsToBeUpdated = true
            }
        }
        _seasonType.value = seasonType
    }

    fun setSeasonYear(seasonYear: String) {
        if (_seasonSelectorState.value is SeasonSelectorState.Visible) {
            val currentSeasonVisibleState =
                (_seasonSelectorState.value as SeasonSelectorState.Visible)
            if (currentSeasonVisibleState.seasonYear != seasonYear) {
                isGamesListNeedsToBeUpdated = true
            }
        }
        _seasonYear.value = seasonYear
    }

//    fun getGames(season: String, seasonType: String) {
//        viewModelScope.launch {
//            _gamesListState.value = GamesListUiState.Loading
//            _gamesListState.value = getGamesUseCaseExecuting(season, seasonType)
//        }
//    }

//    private suspend fun getGamesUseCaseExecuting(
//        season: String,
//        seasonType: String
//    ): GamesListUiState {
//        return withContext(Dispatchers.IO) {
//            try {
//                GamesListUiState.Success(
//                    data = getGamesUseCase.execute(
//                        season = season,
//                        seasonType = seasonType
//                    )
//                )
//            } catch (e: Exception) {
//                GamesListUiState.Error(message = e.message ?: "Some error")
//            }
//        }
//    }

}