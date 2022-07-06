package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GamesAppBar(
    seasonType: String,
    seasonYear: String,
    onTitleClick: () -> Unit
) {

    val seasonName = if (seasonType == "R") {
        "Reg.Season"
    } else {
        "Play-Off"
    }

    TopAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        title = {
            Row(modifier = Modifier.clickable { onTitleClick() }) {
                Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "$seasonName, $seasonYear",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
                Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                    Icon(
                        Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    )
}