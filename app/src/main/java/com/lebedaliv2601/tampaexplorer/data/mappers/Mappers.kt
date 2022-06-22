package com.lebedaliv2601.tampaexplorer.data.mappers

import com.lebedaliv2601.tampaexplorer.data.model.GamesModelData
import com.lebedaliv2601.tampaexplorer.domain.model.GameModel
import com.lebedaliv2601.tampaexplorer.domain.model.TeamModel

fun GamesModelData.DateGamesData.toDomain(): GameModel{

    val game = games.first()
    val awayTeam = game.teams.awayTeam
    val homeTeam = game.teams.homeTeam

    return GameModel(
        gameId = game.gameId,
        gameDate = getDate(game.gameDate),
        awayTeam = TeamModel(awayTeam.team.id, awayTeam.team.name),
        homeTeam = TeamModel(homeTeam.team.id, homeTeam.team.name),
        awayScore = awayTeam.score,
        homeScore = homeTeam.score,
        venue = game.venue.name
    )
}

fun getDate(gameDate: String): String{
    return "${gameDate.substring(8, 10)}.${gameDate.substring(5, 7)}.${gameDate.substring(0, 4)}"
}

fun GamesModelData.toGameModelList(): List<GameModel>{
    return dates.map { it.toDomain() }
}