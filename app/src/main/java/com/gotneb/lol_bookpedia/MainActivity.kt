package com.gotneb.lol_bookpedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gotneb.lol_bookpedia.presentation.screen.champion_details.ChampionDetailScreen
import com.gotneb.lol_bookpedia.presentation.screen.champion_details.ChampionDetailsViewModel
import com.gotneb.lol_bookpedia.presentation.screen.champion_list.ChampionListScreen
import com.gotneb.lol_bookpedia.presentation.screen.champion_list.ChampionListViewModel
import com.gotneb.lol_bookpedia.presentation.util.ChampionDetails
import com.gotneb.lol_bookpedia.presentation.util.ChampionList
import com.gotneb.lol_bookpedia.ui.theme.LOLBookpediaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LOLBookpediaTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = ChampionList,
                ) {
                    composable<ChampionList> {
                        val viewModel = hiltViewModel<ChampionListViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        ChampionListScreen(
                            state = state,
                            onValueChange = viewModel::onSearchTextChange,
                            navigate = { name ->
                                navController.navigate(ChampionDetails(name))
                            }
                        )
                    }

                    composable<ChampionDetails> {
                        val viewmodel = hiltViewModel<ChampionDetailsViewModel>()

                        viewmodel.champion.value?.let {
                            ChampionDetailScreen(it)
                        }
                    }
                }
            }
        }
    }
}