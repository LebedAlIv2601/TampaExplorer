package com.lebedaliv2601.tampaexplorer.data.mappers

import com.lebedaliv2601.tampaexplorer.data.model.*
import com.lebedaliv2601.tampaexplorer.domain.model.*

fun DateGamesData.toDomain(): GameModel {

    val game = games.first()
    val awayTeam = game.teams.awayTeam
    val homeTeam = game.teams.homeTeam

    return GameModel(
        gameId = game.gameId,
        gameDate = getDate(game.gameDate),
        awayTeam = awayTeam.toTeamModel(),
        homeTeam = homeTeam.toTeamModel(),
        awayScore = awayTeam.score,
        homeScore = homeTeam.score,
        venue = game.venue.name
    )
}

fun TeamResultModelData.toTeamModel(): TeamModel {
    return TeamModel(
        id = team.id,
        name = team.name
    )
}

fun getDate(gameDate: String): String {
    return "${gameDate.substring(8, 10)}.${gameDate.substring(5, 7)}.${gameDate.substring(0, 4)}"
}

fun GamesModelData.toGameModelList(): List<GameModel> {
    return dates.map { it.toDomain() }
}

fun SeasonModel.toData(): SeasonModelData {
    return SeasonModelData(
        seasonType = seasonType,
        seasonYear = seasonYear
    )
}

fun SeasonModelData.toDomain(): SeasonModel {
    return SeasonModel(
        seasonType = seasonType,
        seasonYear = seasonYear
    )
}

fun GameInfoModelData.toDomain(): GameInfoModel {

    val awayTeamStats = data.boxscore.teams.awayTeamStats.stats.skaterStats
    val homeTeamStats = data.boxscore.teams.homeTeamStats.stats.skaterStats

    val goals = mutableListOf<GoalModel>()

    for (goalId in data.plays.scoringPlays) {
        goals.add(data.plays.allPlays[goalId].toGoalModel())
    }

    return GameInfoModel(
        stats = GameStatsModel(
            gameId = gameId,
            awayTeamStats = CurrentGameTeamStatsModel(
                shots = awayTeamStats.shots,
                pim = awayTeamStats.pim,
                faceOffWinPercentage = awayTeamStats.faceOffWinPercentage,
                blocked = awayTeamStats.blocked,
                hits = awayTeamStats.hits,
                powerPlayGoals = awayTeamStats.powerPlayGoals,
                powerPlayOpportunities = awayTeamStats.powerPlayOpportunities,
                giveaways = awayTeamStats.giveaways,
                takeaways = awayTeamStats.takeaways
            ),
            homeTeamStats = CurrentGameTeamStatsModel(
                shots = homeTeamStats.shots,
                pim = homeTeamStats.pim,
                faceOffWinPercentage = homeTeamStats.faceOffWinPercentage,
                blocked = homeTeamStats.blocked,
                hits = homeTeamStats.hits,
                powerPlayGoals = homeTeamStats.powerPlayGoals,
                powerPlayOpportunities = homeTeamStats.powerPlayOpportunities,
                giveaways = homeTeamStats.giveaways,
                takeaways = homeTeamStats.takeaways
            )
        ),
        goals = goals
    )
}

fun PlayModelData.toGoalModel(): GoalModel {

    val goalScorer = players[0]
    val firstAssist = if (players.size > 2) {
        players[1]
    } else null
    val secondAssist = if (players.size > 3) {
        players[2]
    } else null

    return GoalModel(
        scorerPLayer = PlayerModel(
            goalScorer.player.id,
            goalScorer.player.name,
            goalScorer.playerType,
            goalScorer.seasonTotal
        ),
        firstAssist = if (firstAssist != null) {
            PlayerModel(
                firstAssist.player.id,
                firstAssist.player.name,
                firstAssist.playerType,
                firstAssist.seasonTotal
            )
        } else null,
        secondAssist = if (secondAssist != null) {
            PlayerModel(
                secondAssist.player.id,
                secondAssist.player.name,
                secondAssist.playerType,
                secondAssist.seasonTotal
            )
        } else null,
        scoringTeam = TeamModel(team.id, team.name),
        goalType = result.secondaryType,
        goalTime = about.periodTime,
        goalPeriod = about.ordinalNum,
        strength = result.strength.code,
        isEmptyNet = result.emptyNet,
        currentHomeScore = about.goals.homeScore,
        currentAwayScore = about.goals.awayScore
    )
}
