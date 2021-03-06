package com.lebedaliv2601.tampaexplorer.domain.model

import java.io.Serializable

data class GameModel(
    val gameId: Long,
    val homeTeam: TeamModel,
    val awayTeam: TeamModel,
    val homeScore: Int,
    val awayScore: Int,
    val gameDate: String,
    val venue: String
) : Serializable
