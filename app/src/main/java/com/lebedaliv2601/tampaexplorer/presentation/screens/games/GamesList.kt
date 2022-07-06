package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.lebedaliv2601.tampaexplorer.domain.model.*
import com.lebedaliv2601.tampaexplorer.domain.model.getTeamShortName


@Composable
fun GamesListForRegular(
    gamesList: List<GameModel>,
    onItemClick: (String, String, String, String) -> Unit
) {

    LazyColumn {

        items(gamesList) { game ->

            GamesListItem(game = game, onItemClick)
            Divider(
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }

}

@ExperimentalFoundationApi
@Composable
fun GamesListForPlayOff(
    gamesList: Map<String, List<GameModel>>,
    onItemClick: (String, String, String, String) -> Unit
) {

    LazyColumn {

        gamesList.forEach { (key, games) ->

            stickyHeader {

                GamesListForPlayOffHeader(key, games)

                Divider(
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .fillMaxWidth()
                )

            }

            items(games) { game ->


                GamesListItem(game = game, onItemClick)

                Divider(
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

        }
    }

}

@Composable
fun GamesListForPlayOffHeader(key: String, games: List<GameModel>) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primaryVariant)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primaryVariant),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "${games.last().awayTeam.getTeamLastName()} " +
                        "vs ${games.last().homeTeam.getTeamLastName()}",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(vertical = 4.dp)
            )

            val leadTeamSeriesScore =
                if (games.first().awayScore > games.first().homeScore) {

                    games.first().awayTeam.getTeamShortName()

                } else {
                    games.first().homeTeam.getTeamShortName()
                }

            Text(
                text = "$key Round, $leadTeamSeriesScore wins 4-${games.size - 4}",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraLight,
                modifier = Modifier
                    .padding(vertical = 4.dp)
            )

        }


    }


}


@Composable
fun GamesListItem(game: GameModel, onItemClick: (String, String, String, String) -> Unit) {

    Card(
        modifier = Modifier
            .clickable {
                onItemClick(
                    "${game.awayScore} - ${game.homeScore}",
                    game.awayTeam.name,
                    game.homeTeam.name,
                    game.gameId.toString()
                )
            }
            .padding(8.dp)
            .fillMaxWidth()
            .height(110.dp),
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Box(modifier = Modifier.weight(3f)) {
                    Image(
                        painter = rememberImagePainter(
                            data = game.awayTeam.getTeamIcon()
                        ),
                        contentDescription = "Away Team Icon",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(5.dp)
                    )
                }

                Text(
                    text = game.awayTeam.name,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    fontSize = 16.sp
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .weight(1f)
                    .fillMaxHeight()
            ) {

                Text(
                    text = "${game.awayScore} - ${game.homeScore}",
                    color = Color.Black,
                    fontSize = 40.sp,
                    modifier = Modifier.weight(2f),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = game.gameDate,
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = game.venue,
                    color = Color.Black,
                    fontSize = 10.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {

                Box(modifier = Modifier.weight(3f)) {
                    Image(
                        painter = rememberImagePainter(
                            data = game.homeTeam.getTeamIcon()
                        ),
                        contentDescription = "Home Team Icon",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(5.dp)
                    )
                }

                Text(
                    text = game.homeTeam.name,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    fontSize = 16.sp
                )
            }
        }
    }

}


@Composable
@Preview
fun GamePreview() {
    GamesListItem(
        game = GameModel(
            gameId = 2017020659,
            homeTeam = TeamModel(20, "Calgary Flames"),
            awayTeam = TeamModel(30, "Minnesota Wild"),
            homeScore = 3,
            awayScore = 2,
            venue = "Xcel Energy Arena",
            gameDate = "09.01.2018"
        )
    ) { _, _, _, _ -> }
}