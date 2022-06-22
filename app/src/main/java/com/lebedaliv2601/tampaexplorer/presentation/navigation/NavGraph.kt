package com.lebedaliv2601.tampaexplorer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lebedaliv2601.tampaexplorer.presentation.screens.games.GamesScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Games.route
    ) {
        composable(route = Screen.Games.route) {
            GamesScreen(navController = navController)
        }
    }
}