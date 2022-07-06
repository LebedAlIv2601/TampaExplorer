package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.lebedaliv2601.tampaexplorer.presentation.navigation.Screen
import com.lebedaliv2601.tampaexplorer.presentation.screens.utils.GamesProgressBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
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
                color = MaterialTheme.colors.background
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
            is GamesListUiState.SuccessRegular -> {
                GamesListForRegular(
                    gamesList = (uiState.value as GamesListUiState.SuccessRegular).data
                ) {gameScore, awayTeamName, homeTeamName, gameId ->
                    navController.navigate(
                        "${Screen.GameInfo.route}/$gameScore/$awayTeamName/$homeTeamName/$gameId"
                    )
                }
            }
            is GamesListUiState.SuccessPlayOff -> {
                GamesListForPlayOff(gamesList = (uiState.value as GamesListUiState.SuccessPlayOff).data)
                {gameScore, awayTeamName, homeTeamName, gameId ->
                    navController.navigate(
                        "${Screen.GameInfo.route}/$gameScore/$awayTeamName/$homeTeamName/$gameId"
                    )
                }
            }
            is GamesListUiState.Error -> {
                Text(text = (uiState.value as GamesListUiState.Error).message)
            }
        }

        val swipeableState = rememberSwipeableState(0)
        val sizePx = with(LocalDensity.current) { 290.dp.toPx() }
        val anchors = mapOf(0f to 0, sizePx to 1)

        val scope = rememberCoroutineScope()
        if (swipeableState.isAnimationRunning) {
            DisposableEffect(Unit) {
                onDispose {
                    when (swipeableState.currentValue) {
                        1 -> {
                            viewModel.changeSelectorState()
                            scope.launch {
                                delay(200)
                                swipeableState.snapTo(0)
                            }
                        }
                    }
                }
            }
        }


        AnimatedVisibility(
            visible = selectorState.value is SeasonSelectorState.Visible,
            enter = slideInVertically(
                initialOffsetY = { 1000 },
                animationSpec = spring(
                    Spring.DampingRatioMediumBouncy
                )
            ),
            exit = slideOutVertically(
                targetOffsetY = { 1000 },
                animationSpec = tween(200)
            )
        ) {

            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier.swipeable(
                        state = swipeableState,
                        anchors = anchors,
                        thresholds = { _, _ -> FractionalThreshold(0.4f) },
                        orientation = Orientation.Vertical
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .offset {
                                IntOffset(0, swipeableState.offset.value.roundToInt())
                            }
                    ) {
                        GamesSeasonSelector(
                            currentSeasonType = seasonType.value,
                            currentSeasonYear = seasonYear.value,
                            onSeasonYearChanged = { viewModel.setSeasonYear(it) },
                            onSeasonTypeChanged = { viewModel.setSeasonType(it) },
                            onButtonApplyClick = { viewModel.changeSelectorState() }
                        )
                    }
                }

            }
        }

    }
}