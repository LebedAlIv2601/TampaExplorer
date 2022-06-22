package com.lebedaliv2601.tampaexplorer.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GamesModelData(

    @Json(name = "dates")
    val dates: List<DateGamesData>
) {

    @JsonClass(generateAdapter = true)
    data class DateGamesData(
        @Json(name = "games")
        val games: List<GameModelData>
    )

    @JsonClass(generateAdapter = true)
    data class GameModelData(
        @Json(name = "gamePk")
        val gameId: Long,

        @Json(name = "gameDate")
        val gameDate: String,

        @Json(name = "teams")
        val teams: TeamsModelData,

        @Json(name = "venue")
        val venue: VenueModelData
    )

    @JsonClass(generateAdapter = true)
    data class VenueModelData(
        @Json(name = "name")
        val name: String
    )

    @JsonClass(generateAdapter = true)
    data class TeamsModelData(
        @Json(name = "away")
        val awayTeam: TeamResultModelData,

        @Json(name = "home")
        val homeTeam: TeamResultModelData
    )

    @JsonClass(generateAdapter = true)
    data class TeamResultModelData(
        @Json(name = "score")
        val score: Int,

        @Json(name = "team")
        val team: TeamModelData
        )

    @JsonClass(generateAdapter = true)
    data class TeamModelData(
        @Json(name = "id")
        val id: Int,

        @Json(name = "name")
        val name: String
    )
}


