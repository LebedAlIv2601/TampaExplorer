package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.lebedaliv2601.tampaexplorer.domain.model.GameModel
import com.lebedaliv2601.tampaexplorer.domain.model.TeamModel
import com.lebedaliv2601.tampaexplorer.domain.model.getTeamIcon


@Composable
fun GamesList(gamesList: List<GameModel>){

    LazyColumn{

        items(gamesList){game ->

            GamesListItem(game = game)
            Divider(
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }

}


@Composable
fun GamesListItem(game: GameModel) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(110.dp),
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
    ) {

        Row(horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically) {

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
                            .clip(shape = CircleShape)
                            .background(shape = CircleShape, color = Color.White)
                            .padding(5.dp)
                    )
                }

                Text(
                    text = game.awayTeam.name,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    fontSize = 16.sp
                )
            }

            Column (horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .weight(1f)
                    .fillMaxHeight()){

                Text(
                    text = "${game.awayScore} - ${game.homeScore}",
                    color = Color.White,
                    fontSize = 40.sp,
                    modifier = Modifier.weight(2f),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = game.gameDate,
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = game.venue,
                    color = Color.White,
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
                           .clip(shape = CircleShape)
                           .background(shape = CircleShape, color = Color.White)
                           .padding(5.dp)
                   )
               }

                Text(
                    text = game.homeTeam.name,
                    textAlign = TextAlign.Center,
                    color = Color.White,
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
    )
}