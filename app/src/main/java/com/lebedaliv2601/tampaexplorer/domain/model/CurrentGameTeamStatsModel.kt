package com.lebedaliv2601.tampaexplorer.domain.model

data class CurrentGameTeamStatsModel(
    val pim: Int,
    val shots: Int,
    val faceOffWinPercentage: Float,
    val blocked: Int,
    val hits: Int,
    val powerPlayGoals: Int,
    val powerPlayOpportunities: Int,
    val takeaways: Int,
    val giveaways: Int
)
