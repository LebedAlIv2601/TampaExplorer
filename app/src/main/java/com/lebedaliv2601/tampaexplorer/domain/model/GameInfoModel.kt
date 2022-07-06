package com.lebedaliv2601.tampaexplorer.domain.model

data class GameInfoModel(
    val stats: GameStatsModel,

    val goals: List<GoalModel>
)
