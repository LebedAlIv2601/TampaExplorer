package com.lebedaliv2601.tampaexplorer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = MediumBlue,
    primaryVariant = DarkBlue,
    secondary = LightBlue,
    surface = LightGray,
    onSurface = DarkGray,
    background = BackgroundWhite
)

private val LightColorPalette = lightColors(
    primary = MediumBlue,
    primaryVariant = DarkBlue,
    secondary = LightBlue,
    surface = LightGray,
    onSurface = DarkGray,
    background = BackgroundWhite

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun TampaExplorerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}