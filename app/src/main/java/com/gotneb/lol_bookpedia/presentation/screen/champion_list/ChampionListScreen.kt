package com.gotneb.lol_bookpedia.presentation.screen.champion_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gotneb.lol_bookpedia.presentation.screen.champion_list.composable.ChampionCard
import com.gotneb.lol_bookpedia.ui.theme.LOLBookpediaTheme

@Composable
fun ChampionListScreen(
    state: ChampionListState,
    onValueChange: (String) -> Unit,
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(20.dp)
        ) {
            OutlinedTextField(
                value = state.searchText,
                onValueChange = onValueChange,
                placeholder = {
                    Text(text = "Search for champs")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null,

                        )
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.filteredChampions.ifEmpty { state.champions }) { champion ->
                    ChampionCard(
                        champion,
                        modifier = Modifier.animateItem()
                    )
                }
            }
        }
    }
}