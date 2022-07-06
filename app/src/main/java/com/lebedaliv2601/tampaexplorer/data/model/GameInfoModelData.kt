package com.lebedaliv2601.tampaexplorer.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameInfoModelData(

    @Json(name = "gamePk")
    val gameId: Long,

    @Json(name = "liveData")
    val data: GameInfoData

)

@JsonClass(generateAdapter = true)
data class GameInfoData(

    @Json(name = "boxscore")
    val boxscore: BoxscoreData,

    @Json(name = "plays")
    val plays: PlaysData
)

@JsonClass(generateAdapter = true)
data class PlaysData(

    @Json(name = "scoringPlays")
    val scoringPlays: List<Int>,

    @Json(name = "allPlays")
    val allPlays: List<PlayModelData>
)

@JsonClass(generateAdapter = true)
data class PlayModelData(

    @Json(name = "players")
    val players: List<PlayerModelData> = listOf(),

    @Json(name = "result")
    val result: PlayResultModelData,

    @Json(name = "about")
    val about: PlayAboutModelData,

    @Json(name = "team")
    val team: TeamData = TeamData(0,"")
)

@JsonClass(generateAdapter = true)
data class TeamData(

    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String
)

@JsonClass(generateAdapter = true)
data class PlayAboutModelData(

    @Json(name = "ordinalNum")
    val ordinalNum: String,

    @Json(name = "periodTime")
    val periodTime: String,

    @Json(name = "goals")
    val goals: GoalsData,
)

@JsonClass(generateAdapter = true)
data class GoalsData(

    @Json(name = "away")
    val awayScore: Int,

    @Json(name = "home")
    val homeScore: Int
)

@JsonClass(generateAdapter = true)
data class PlayResultModelData(

    @Json(name = "event")
    val event: String,

    @Json(name = "secondaryType")
    val secondaryType: String = "None",

    @Json(name = "emptyNet")
    val emptyNet: Boolean = false,

    @Json(name = "strength")
    val strength: StrengthModelData = StrengthModelData("None"),
)

@JsonClass(generateAdapter = true)
data class StrengthModelData(

    @Json(name = "code")
    val code: String
)

@JsonClass(generateAdapter = true)
data class PlayerModelData(

    @Json(name = "player")
    val player: PlayerInfoData,

    @Json(name = "playerType")
    val playerType: String,

    @Json(name = "seasonTotal")
    val seasonTotal: Int = 0,
)

@JsonClass(generateAdapter = true)
data class PlayerInfoData(

    @Json(name = "id")
    val id: Long,

    @Json(name = "fullName")
    val name: String
)

@JsonClass(generateAdapter = true)
data class BoxscoreData(

    @Json(name = "teams")
    val teams: TeamsData
)

@JsonClass(generateAdapter = true)
data class TeamsData(

    @Json(name = "away")
    val awayTeamStats: TeamStatsData,

    @Json(name = "home")
    val homeTeamStats: TeamStatsData
)

@JsonClass(generateAdapter = true)
data class TeamStatsData(

    @Json(name = "teamStats")
    val stats: TeamSkaterStatsObj
)

@JsonClass(generateAdapter = true)
data class TeamSkaterStatsObj(

    @Json(name = "teamSkaterStats")
    val skaterStats: TeamSkaterStats
)


@JsonClass(generateAdapter = true)
data class TeamSkaterStats(

    @Json(name = "pim")
    val pim: Int = 0,

    @Json(name = "shots")
    val shots: Int = 0,

    @Json(name = "blocked")
    val blocked: Int = 0,

    @Json(name = "takeaways")
    val takeaways: Int = 0,

    @Json(name = "giveaways")
    val giveaways: Int = 0,

    @Json(name = "hits")
    val hits: Int = 0,

    @Json(name = "powerPlayGoals")
    val powerPlayGoals: Int = 0,

    @Json(name = "powerPlayOpportunities")
    val powerPlayOpportunities: Int = 0,

    @Json(name = "faceOffWinPercentage")
    val faceOffWinPercentage: Float = 0f

)