package com.gotneb.lol_bookpedia.presentation.screen.champion_details

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.gotneb.lol_bookpedia.domain.model.ChampionModel
import com.gotneb.lol_bookpedia.domain.repository.ApiRepository
import com.gotneb.lol_bookpedia.presentation.util.ChampionDetails
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "DETAILS"

@HiltViewModel
class ChampionDetailsViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

    var champion = mutableStateOf<ChampionModel?>(null)

    init {
        val args = savedStateHandle.toRoute<ChampionDetails>()

        viewModelScope.launch {
            repository.getChampionByName(args.name)
                .onSuccess {
                    Log.d(TAG, "ChampionDetailsViewModel: $data")
                    champion.value = data.champion.values.firstOrNull()
                }
                .onFailure {
                    Log.d(TAG, "ChampionDetailsViewModel: ${message()}")
                }
                .onError {
                    Log.d(TAG, "ChampionDetailsViewModel: ${message()}")
                }
        }
    }
}