package com.lebedaliv2601.tampaexplorer.presentation.navigation

import com.lebedaliv2601.tampaexplorer.domain.model.GameModel

sealed class Screen(val route: String) {
    object Games : Screen("games_screen")
    object GameInfo : Screen("game_info_screen")

//            /{game}"){
//        fun passGame(game: GameModel) = "game_info_scree/$game"
//}
//    object MovieDetails : Screen("movie_details_screen/{movieId}") {
//        fun passMovieId(movieId: String) = "movie_details_screen/$movieId"
//    }
}