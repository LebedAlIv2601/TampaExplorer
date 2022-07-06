package com.lebedaliv2601.tampaexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.lebedaliv2601.tampaexplorer.presentation.navigation.MainNavGraph
import com.lebedaliv2601.tampaexplorer.ui.theme.TampaExplorerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TampaExplorerTheme {
                val navController = rememberNavController()
                MainNavGraph(navController = navController)
            }
        }
    }
}