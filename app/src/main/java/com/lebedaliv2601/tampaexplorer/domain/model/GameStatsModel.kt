package com.lebedaliv2601.tampaexplorer.domain.model

data class GameStatsModel(
    val gameId: Long,
    val awayTeamStats: CurrentGameTeamStatsModel,
    val homeTeamStats: CurrentGameTeamStatsModel
)