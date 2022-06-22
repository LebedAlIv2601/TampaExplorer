package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun GamesScreen(
    navController: NavHostController,
    viewModel: GamesViewModel = hiltViewModel()) {

    val uiState = viewModel.gamesList.collectAsState()

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
            GamesAppBar()
        }

    ) {
        when(uiState.value){
            is GamesScreenUiState.Loading -> {
                GamesProgressBar()
            }
            is GamesScreenUiState.Success -> {
                GamesList(gamesList = (uiState.value as GamesScreenUiState.Success).data)
            }
            is GamesScreenUiState.Error -> {
                Text(text = (uiState.value as GamesScreenUiState.Error).message)
            }
        }
    }
}