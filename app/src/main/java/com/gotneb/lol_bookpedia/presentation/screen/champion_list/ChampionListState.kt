package com.gotneb.lol_bookpedia.presentation.screen.champion_list

import com.gotneb.lol_bookpedia.domain.model.ChampionModel

data class ChampionListState(
    val searchText: String = "",
    val champions: List<ChampionModel> = emptyList(),
    val filteredChampions: List<ChampionModel> = emptyList(),
)