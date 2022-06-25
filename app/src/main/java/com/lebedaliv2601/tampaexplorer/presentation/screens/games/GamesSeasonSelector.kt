package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lebedaliv2601.tampaexplorer.R
import com.lebedaliv2601.tampaexplorer.ui.theme.TampaExplorerTheme

@Composable
fun GamesSeasonSelector(
    currentSeasonType: String,
    currentSeasonYear: String,
    onSeasonYearChanged: (String) -> Unit,
    onSeasonTypeChanged: (String) -> Unit,
    onButtonApplyClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(260.dp),
        backgroundColor = Color.White,
        elevation = 4.dp,
        shape = AbsoluteRoundedCornerShape(
            corner = CornerSize(20.dp)
        ),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 24.dp)
        ) {

            SeasonYearSelector(
                currentSeasonYear,
                onSeasonChanged = onSeasonYearChanged
            )
            Spacer(modifier = Modifier.height(16.dp))
            SeasonTypeSelector(
                currentSeasonType = currentSeasonType,
                onButtonClick = onSeasonTypeChanged
            )
            Spacer(modifier = Modifier.height(16.dp))
            BlueButton(
                text = "Apply",
                onButtonClick = onButtonApplyClick
            )
        }

    }

}

@Composable
fun SeasonYearSelector(
    currentSeasonYear: String,
    onSeasonChanged: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Season:", color = Color.Black, fontSize = 20.sp)

        Box {

            Text(
                text = currentSeasonYear,
                color = MaterialTheme.colors.secondary,
                fontSize = 20.sp,
                modifier = Modifier
                    .clickable { expanded = true })

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {

                for (season in seasons) {
                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                            onSeasonChanged(season)
                        },
                        modifier = Modifier.background(Color.White)
                    ) {
                        Text(
                            text = season,
                            color = Color.Black,
                            fontSize = 20.sp
                        )
                    }
                    Divider()
                }
            }
        }
    }
}

@Composable
fun SeasonTypeSelector(
    currentSeasonType: String,
    onButtonClick: (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {

        val isRegularSelected = currentSeasonType == "R"

        CircleButtonWithIcon(
            seasonType = "R",
            isSelected = isRegularSelected,
            onButtonClick = onButtonClick
        )

        CircleButtonWithIcon(
            seasonType = "P",
            isSelected = !isRegularSelected,
            onButtonClick = onButtonClick
        )
    }
}

@Composable
fun BlueButton(
    text: String,
    onButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .clickable { onButtonClick() },
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = 0.dp,
        shape = AbsoluteRoundedCornerShape(
            corner = CornerSize(20.dp)
        ),
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
    }
}

@Composable
fun CircleButtonWithIcon(
    seasonType: String,
    isSelected: Boolean,
    onButtonClick: (String) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(
                id = if (seasonType == "R") {
                    R.drawable.regular_season_icon
                } else {
                    R.drawable.play_off_icon
                }
            ),
            tint = if (isSelected) {
                Color.White
            } else {
                MaterialTheme.colors.surface
            },
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(shape = CircleShape)
                .background(
                    color = if (isSelected) {
                        MaterialTheme.colors.primary
                    } else {
                        Color.White
                    },
                    CircleShape
                )
                .border(
                    width = 1.dp,
                    color = if (isSelected) {
                        MaterialTheme.colors.primary
                    } else {
                        MaterialTheme.colors.surface
                    },
                    shape = CircleShape
                )
                .clickable { onButtonClick(seasonType) }
                .padding(8.dp)
        )

        Text(
            text = if (seasonType == "R") {
                "Regular Season"
            } else {
                "Play-Off"
            },
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 20.sp,
            modifier = Modifier.width(100.dp)
        )
    }


}

private val seasons = listOf(
    "2021-2022", "2020-2021", "2019-2020", "2018-2019", "2017-2018",
    "2016-2017", "2015-2016", "2014-2015", "2013-2014", "2012-2013",
    "2011-2012", "2010-2011", "2009-2010", "2008-2009", "2007-2008",
    "2006-2007", "2005-2006", "2003-2004", "2002-2003",
    "2001-2002", "2000-2001", "1999-2000", "1998-1999", "1997-1998",
    "1996-1997", "1995-1996", "1994-1995", "1993-1994", "1992-1993"
)


@Composable
@Preview
fun CircleButtonPreview() {
    TampaExplorerTheme {
        CircleButtonWithIcon(seasonType = "P", isSelected = true, onButtonClick = {})

    }
}

@Composable
@Preview
fun GamesSelectorPreview() {
    TampaExplorerTheme {
        GamesSeasonSelector(
            "R",
            "2021-2022",
            {},
            {},
            {})
    }

}