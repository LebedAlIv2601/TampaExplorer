package com.lebedaliv2601.tampaexplorer.presentation.screens.game_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.lebedaliv2601.tampaexplorer.domain.model.GoalModel
import com.lebedaliv2601.tampaexplorer.domain.model.PlayerModel
import com.lebedaliv2601.tampaexplorer.domain.model.TeamModel
import com.lebedaliv2601.tampaexplorer.domain.model.getTeamIcon
import com.lebedaliv2601.tampaexplorer.ui.theme.TampaExplorerTheme

@ExperimentalPagerApi
@Composable
fun ScoringSummary(goals: List<GoalModel>) {

    HorizontalPager(
        count = goals.size,
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp)
    ) { goal ->

        GoalCard(goal = goals[goal])

    }

}

@Composable
fun ScoringSummaryHeader() {

    Text(
        text = "Scoring Summary",
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
fun GoalCard(
    goal: GoalModel
) {

    Card(
        backgroundColor = Color.White,
        elevation = 4.dp,
        shape = AbsoluteRoundedCornerShape(
            corner = CornerSize(20.dp)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(horizontal = 8.dp)
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(6f)
                    .padding(horizontal = 8.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 16.dp)
                ) {

                    Image(
                        painter = rememberImagePainter(
                            data = goal.scoringTeam.getTeamIcon()
                        ),
                        contentDescription = "Away Team Icon",
                        modifier = Modifier
                            .size(60.dp)
                    )

                    Text(
                        text = "${goal.currentAwayScore} - ${goal.currentHomeScore}",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .fillMaxHeight()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "G",
                            color = MaterialTheme.colors.primaryVariant,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .size(23.dp)
                                .border(
                                    width = 3.dp,
                                    color = MaterialTheme.colors.primaryVariant,
                                    shape = CircleShape
                                )
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = "${goal.scorerPLayer.name} (${goal.scorerPLayer.seasonTotal})",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    if (goal.firstAssist != null) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(start = 2.dp)
                        ) {
                            Text(
                                text = "A",
                                color = MaterialTheme.colors.primaryVariant,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .size(17.dp)
                                    .border(
                                        width = 1.dp,
                                        color = MaterialTheme.colors.primaryVariant,
                                        shape = CircleShape
                                    )
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = "${goal.firstAssist.name} (${goal.firstAssist.seasonTotal})",
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    if (goal.secondAssist != null) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(start = 2.dp)
                        ) {
                            Text(
                                text = "A",
                                color = MaterialTheme.colors.primaryVariant,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .size(17.dp)
                                    .border(
                                        width = 1.dp,
                                        color = MaterialTheme.colors.primaryVariant,
                                        shape = CircleShape
                                    )
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = "${goal.secondAssist.name} (${goal.secondAssist.seasonTotal})",
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }

            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            ) {
                Text(
                    text = "${goal.goalTime}, ${goal.goalPeriod}",
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )

                Text(
                    text = goal.goalType,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )

                if (goal.isEmptyNet) {
                    Text(
                        text = "EN",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                color = MaterialTheme.colors.primaryVariant,
                                shape = CircleShape
                            )
                            .padding(4.dp)
                    )
                }

                if (goal.strength != "EVEN") {
                    Text(
                        text = goal.strength,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .clip(CircleShape)
                            .background(
                                color = MaterialTheme.colors.primaryVariant,
                                shape = CircleShape
                            )
                            .padding(4.dp)
                    )
                }

            }

        }


    }

}

@Composable
@Preview
fun GoalCardPreview() {
    TampaExplorerTheme {
        GoalCard(
            GoalModel(
                scorerPLayer = PlayerModel(82191, "N. Kucherov", "Scorer", 8),
                firstAssist = PlayerModel(9929, "S. Stamkos", "Assist", 8),
                secondAssist = PlayerModel(281382, "C. Perry", "Assist", 5),
//                firstAssist = null,
//                secondAssist = null,
                scoringTeam = TeamModel(14, "Tampa Bay Lightning"),
                goalType = "Slap Shot",
                goalTime = "08:10",
                goalPeriod = "2nd",
                strength = "PPG",
                isEmptyNet = true,
                currentHomeScore = 2,
                currentAwayScore = 1
            )
        )
    }
}