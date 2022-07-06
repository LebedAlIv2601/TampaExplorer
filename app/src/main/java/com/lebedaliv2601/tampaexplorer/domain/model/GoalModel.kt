package com.lebedaliv2601.tampaexplorer.domain.model

data class GoalModel(
    val scorerPLayer: PlayerModel,
    val firstAssist: PlayerModel?,
    val secondAssist: PlayerModel?,
    val scoringTeam: TeamModel,
    val goalType: String,
    val goalTime: String,
    val goalPeriod: String,
    val strength: String,
    val isEmptyNet: Boolean,
    val currentHomeScore: Int,
    val currentAwayScore: Int
)