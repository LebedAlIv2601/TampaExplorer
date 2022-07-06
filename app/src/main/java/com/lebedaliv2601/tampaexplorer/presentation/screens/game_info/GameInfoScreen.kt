package com.lebedaliv2601.tampaexplorer.presentation.screens.game_info

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.lebedaliv2601.tampaexplorer.domain.model.*
import com.lebedaliv2601.tampaexplorer.presentation.screens.utils.GamesProgressBar

@ExperimentalPagerApi
@Composable
fun GameInfoScreen(
    navController: NavHostController,
    gameScore: String,
    awayTeamName: String,
    homeTeamName: String,
    gameId: String,
    viewModel: GameInfoViewModel = hiltViewModel()
) {

    val uiState = viewModel.uiState.collectAsState()

    if(uiState.value is GameInfoUIState.StartLoading){
        viewModel.getGameInfo(gameId = gameId.toLong())
    }

    Scaffold(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.background
            ),
        topBar = {
            GameInfoAppBar(
                gameScore = gameScore,
                awayTeamIcon = getTeamIconByName(awayTeamName),
                homeTeamIcon = getTeamIconByName(homeTeamName)
            ) { navController.popBackStack() }
        },
        backgroundColor = Color.Transparent,
    ) {

        when(uiState.value){
            is GameInfoUIState.Success -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.verticalScroll(ScrollState(0))
                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        backgroundColor = Color.White
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(bottom = 16.dp)
                        ) {
                            ScoringSummaryHeader()
                            ScoringSummary(goals = (uiState.value as GameInfoUIState.Success).data.goals)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        backgroundColor = Color.White
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(bottom = 16.dp, start = 8.dp, end = 8.dp)
                        ) {
                            GameStatsHeader()
                            GameStats(gameStats = (uiState.value as GameInfoUIState.Success).data.stats)
                        }
                    }
                }
            }
            is GameInfoUIState.Error -> { Text(text = (uiState.value as GameInfoUIState.Error).message, color = Color.Black)}
            is GameInfoUIState.Loading -> { GamesProgressBar() }
            else -> {Text(text = "fass")}
        }
    }

}
