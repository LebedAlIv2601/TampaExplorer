package com.lebedaliv2601.tampaexplorer.presentation.screens.games

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GamesProgressBar(){

    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        CircularProgressIndicator(color = Color.White, strokeWidth = 6.dp)
    }

}


@Composable
@Preview
fun GamesProgressBarPreview(){
    GamesProgressBar()
}