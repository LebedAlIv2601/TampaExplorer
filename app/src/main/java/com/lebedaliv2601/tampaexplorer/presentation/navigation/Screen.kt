package com.lebedaliv2601.tampaexplorer.presentation.navigation

sealed class Screen(val route: String) {
    object Games : Screen("games_screen")
//    object MovieDetails : Screen("movie_details_screen/{movieId}") {
//        fun passMovieId(movieId: String) = "movie_details_screen/$movieId"
//    }
}