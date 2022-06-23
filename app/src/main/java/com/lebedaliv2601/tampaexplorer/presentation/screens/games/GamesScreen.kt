package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun GamesScreen(
    navController: NavHostController,
    viewModel: GamesViewModel = hiltViewModel()
) {

    val uiState = viewModel.gamesListState.collectAsState()
    val selectorState = viewModel.seasonSelectorState.collectAsState()
    val seasonType = viewModel.seasonType.collectAsState()
    val seasonYear = viewModel.seasonYear.collectAsState()

    Scaffold(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.primary,
                        MaterialTheme.colors.primaryVariant,
                        Color.Black
                    )
                )
            ),
        backgroundColor = Color.Transparent,
        topBar = {
            GamesAppBar(
                seasonType = seasonType.value,
                seasonYear = seasonYear.value,
                onTitleClick = { viewModel.changeSelectorState() }
            )
        }

    ) {
        when (uiState.value) {
            is GamesListUiState.Loading -> {
                GamesProgressBar()
            }
            is GamesListUiState.Success -> {
                GamesList(gamesList = (uiState.value as GamesListUiState.Success).data)
            }
            is GamesListUiState.Error -> {
                Text(text = (uiState.value as GamesListUiState.Error).message)
            }
        }

        if (selectorState.value is SeasonSelectorState.Visible) {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxHeight()
            ) {
                GamesSeasonSelector(
                    currentSeasonType = seasonType.value,
                    currentSeasonYear = seasonYear.value,
                    onSeasonYearChanged = { viewModel.setSeasonYear(it) },
                    onSeasonTypeChanged = { viewModel.setSeasonType(it) }
                )
            }
        }
    }
}