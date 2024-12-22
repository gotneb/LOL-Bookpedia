package com.gotneb.lol_bookpedia.presentation.util

import kotlinx.serialization.Serializable

@Serializable
data object ChampionList

@Serializable
data class ChampionDetails(val name: String)