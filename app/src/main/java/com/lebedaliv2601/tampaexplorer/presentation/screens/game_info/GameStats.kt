package com.lebedaliv2601.tampaexplorer.presentation.screens.game_info

import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lebedaliv2601.tampaexplorer.domain.model.GameStatsModel
import com.lebedaliv2601.tampaexplorer.ui.theme.TampaExplorerTheme

@Composable
fun GameStatsHeader(){
    Text(
        text = "Game Stats",
        fontSize = 20.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    )
}

@Composable
fun GameStats(
    gameStats: GameStatsModel
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val awayTeamStats = gameStats.awayTeamStats
        val homeTeamStats = gameStats.homeTeamStats

        StatsItem(
            statsName = "Shots on Goal",
            awayStats = awayTeamStats.shots,
            homeStats = homeTeamStats.shots
        )

        StatsItem(
            statsName = "Hits",
            awayStats = awayTeamStats.hits,
            homeStats = homeTeamStats.hits
        )

        StatsItem(
            statsName = "Blocks",
            awayStats = awayTeamStats.blocked,
            homeStats = homeTeamStats.blocked
        )

        StatsItem(
            statsName = "Faceoff %",
            awayStats = awayTeamStats.faceOffWinPercentage,
            homeStats = homeTeamStats.faceOffWinPercentage
        )

        StatsItem(
            statsName = "Penalty Minutes",
            awayStats = awayTeamStats.pim,
            homeStats = homeTeamStats.pim
        )

        StatsItem(
            statsName = "Power Play Goals",
            awayStats = awayTeamStats.powerPlayGoals,
            homeStats = homeTeamStats.powerPlayGoals
        )

        StatsItem(
            statsName = "Power Play Chances",
            awayStats = awayTeamStats.powerPlayOpportunities,
            homeStats = homeTeamStats.powerPlayOpportunities
        )

        StatsItem(
            statsName = "Giveaways",
            awayStats = awayTeamStats.giveaways,
            homeStats = homeTeamStats.giveaways
        )

        StatsItem(
            statsName = "Takeaways",
            awayStats = awayTeamStats.takeaways,
            homeStats = homeTeamStats.takeaways
        )


    }

}

@Composable
fun StatsItem(
    statsName: String,
    awayStats: Float,
    homeStats: Float
) {

    val awayPercentage = awayStats / (awayStats + homeStats)
    val homePercentage = homeStats / (awayStats + homeStats)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = awayStats.toString(),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = statsName,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )

            Text(
                text = homeStats.toString(),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            LinearProgressIndicator(
                progress = if (awayStats != 0f) {1 - awayPercentage} else {1f},
                backgroundColor = MaterialTheme.colors.primaryVariant,
                color = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(4.dp))
            LinearProgressIndicator(
                progress = homePercentage,
                color = MaterialTheme.colors.primaryVariant,
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )

        }
    }

}

@Composable
fun StatsItem(
    statsName: String,
    awayStats: Int,
    homeStats: Int
) {

    val awayPercentage = awayStats.toFloat() / (awayStats.toFloat() + homeStats.toFloat())
    val homePercentage = homeStats.toFloat() / (awayStats.toFloat() + homeStats.toFloat())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = awayStats.toString(),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = statsName,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )

            Text(
                text = homeStats.toString(),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            LinearProgressIndicator(
                progress = if (awayStats != 0) {1 - awayPercentage} else {1f},
                backgroundColor = MaterialTheme.colors.primaryVariant,
                color = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(4.dp))
            LinearProgressIndicator(
                progress = homePercentage,
                color = MaterialTheme.colors.primaryVariant,
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )

        }
    }


}

@Composable
@Preview
fun StatsItemPreview() {
    TampaExplorerTheme() {
        StatsItem(statsName = "Shots", awayStats = 6, homeStats = 31)
    }
}