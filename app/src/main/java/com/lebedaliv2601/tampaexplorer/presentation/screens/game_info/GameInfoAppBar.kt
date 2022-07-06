package com.lebedaliv2601.tampaexplorer.presentation.screens.game_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.lebedaliv2601.tampaexplorer.domain.model.GameModel
import com.lebedaliv2601.tampaexplorer.domain.model.getTeamIcon

@Composable
fun GameInfoAppBar(
    gameScore: String,
    awayTeamIcon: String,
    homeTeamIcon: String,
    onNavigationIconClick: () -> Unit
) {

    TopAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier.height(80.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Transparent),
            contentAlignment = Alignment.CenterStart
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxHeight()) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { onNavigationIconClick() }
                        .padding(start = 8.dp))
            }

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = rememberImagePainter(
                            data = awayTeamIcon
                        ),
                        contentDescription = "Away Team Icon",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(5.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color.White, shape = CircleShape)
                            .padding(5.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = gameScore,
                        color = Color.White,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Image(
                        painter = rememberImagePainter(
                            data = homeTeamIcon
                        ),
                        contentDescription = "Home Team Icon",
                        modifier = Modifier
                            .size(60.dp)
                            .padding(5.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color.White, shape = CircleShape)
                            .padding(5.dp)
                    )
                }
            }
        }


    }

}