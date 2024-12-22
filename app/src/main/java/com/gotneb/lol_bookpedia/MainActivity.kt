package com.gotneb.lol_bookpedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gotneb.lol_bookpedia.presentation.screen.champion_list.ChampionListScreen
import com.gotneb.lol_bookpedia.presentation.screen.champion_list.ChampionListViewModel
import com.gotneb.lol_bookpedia.ui.theme.LOLBookpediaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LOLBookpediaTheme {
                val viewModel = hiltViewModel<ChampionListViewModel>()

                val state by viewModel.state.collectAsStateWithLifecycle()

                ChampionListScreen(
                    state = state,
                    onValueChange = viewModel::onSearchTextChange
                )
            }
        }
    }
}