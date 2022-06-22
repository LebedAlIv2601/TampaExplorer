package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.material.LinearProgressIndicator
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
import com.lebedaliv2601.tampaexplorer.domain.model.GameModel
import com.lebedaliv2601.tampaexplorer.domain.model.TeamModel
import com.lebedaliv2601.tampaexplorer.utils.UiState

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
            is UiState.Loading -> {
                GamesProgressBar()
            }
            is UiState.Success -> {
                uiState.value.data?.let { list -> GamesList(gamesList = list) }
            }
            is UiState.Error -> {
                uiState.value.message?.let { it1 -> Text(text = it1) }
            }
        }
    }
}


private val gamesList = listOf<GameModel>(
    GameModel(
        gameId = 2017020659,
        homeTeam = TeamModel(20, "Tampa Bay Lightning"),
        awayTeam = TeamModel(30, "Minnesota Wild"),
        homeScore = 3,
        awayScore = 2,
        venue = "Xcel Energy Arena",
        gameDate = "09.01.2018"
    ),
    GameModel(
        gameId = 2017020659,
        homeTeam = TeamModel(20, "Calgary Flames"),
        awayTeam = TeamModel(30, "Minnesota Wild"),
        homeScore = 7,
        awayScore = 9,
        venue = "Xcel Energy Arena",
        gameDate = "09.01.2018"
    ),
    GameModel(
        gameId = 2017020659,
        homeTeam = TeamModel(20, "Tampa Bay Lightning"),
        awayTeam = TeamModel(30, "Calgary Flames"),
        homeScore = 0,
        awayScore = 1,
        venue = "Xcel Energy Arena",
        gameDate = "09.01.2018"
    ),
    GameModel(
        gameId = 2017020659,
        homeTeam = TeamModel(20, "Calgary Flames"),
        awayTeam = TeamModel(30, "Tampa Bay Lightning"),
        homeScore = 3,
        awayScore = 4,
        venue = "Xcel Energy Arena",
        gameDate = "09.01.2018"
    ),
    GameModel(
        gameId = 2017020659,
        homeTeam = TeamModel(20, "Seattle Kraken"),
        awayTeam = TeamModel(30, "Nashville Predators"),
        homeScore = 2,
        awayScore = 7,
        venue = "Xcel Energy Arena",
        gameDate = "09.01.2018"
    ),
    GameModel(
        gameId = 2017020659,
        homeTeam = TeamModel(20, "Pittsburgh Penguins"),
        awayTeam = TeamModel(30, "Boston Bruins"),
        homeScore = 6,
        awayScore = 1,
        venue = "Xcel Energy Arena",
        gameDate = "09.01.2018"
    ),
    GameModel(
        gameId = 2017020659,
        homeTeam = TeamModel(20, "Toronto Maple Leafs"),
        awayTeam = TeamModel(30, "Washington Capitals"),
        homeScore = 3,
        awayScore = 2,
        venue = "Xcel Energy Arena",
        gameDate = "09.01.2018"
    ),
    GameModel(
        gameId = 2017020659,
        homeTeam = TeamModel(20, "Winnipeg Jets"),
        awayTeam = TeamModel(30, "Columbus Blue Jackets"),
        homeScore = 3,
        awayScore = 2,
        venue = "Xcel Energy Arena",
        gameDate = "09.01.2018"
    )
)