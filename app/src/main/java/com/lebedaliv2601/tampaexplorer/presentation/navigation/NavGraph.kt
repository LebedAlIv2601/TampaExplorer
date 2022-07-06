package com.lebedaliv2601.tampaexplorer.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.lebedaliv2601.tampaexplorer.presentation.screens.game_info.GameInfoScreen
import com.lebedaliv2601.tampaexplorer.presentation.screens.games.GamesScreen

@ExperimentalPagerApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Games.route
    ) {
        composable(route = Screen.Games.route) {
            GamesScreen(navController = navController)
        }

        composable(
            route = "${Screen.GameInfo.route}/{gameScore}/{awayTeamName}/{homeTeamName}/{gameId}"
        ) {

            GameInfoScreen(
                navController = navController,
                it.arguments?.getString("gameScore")!!,
                it.arguments?.getString("awayTeamName")!!,
                it.arguments?.getString("homeTeamName")!!,
                it.arguments?.getString("gameId")!!
            )

        }
    }
}