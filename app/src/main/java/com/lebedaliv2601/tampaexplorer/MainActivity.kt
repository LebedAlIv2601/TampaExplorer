package com.lebedaliv2601.tampaexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.lebedaliv2601.tampaexplorer.presentation.navigation.MainNavGraph
import com.lebedaliv2601.tampaexplorer.ui.theme.TampaExplorerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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