package com.lebedaliv2601.tampaexplorer.presentation.screens.games

sealed class SeasonSelectorState{

    class Visible(val seasonType: String, val seasonYear: String) : SeasonSelectorState()

    object Invisible : SeasonSelectorState()
}
