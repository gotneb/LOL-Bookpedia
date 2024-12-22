package com.gotneb.lol_bookpedia.data.repository

import com.gotneb.lol_bookpedia.domain.model.ChampionResponseModel
import com.gotneb.lol_bookpedia.domain.repository.ApiRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import io.ktor.client.HttpClient

object API {
    const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/14.24.1/data/en_US/"

    const val IMG_SPLASH_URL  = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/"
    const val IMG_LOADING_URL = "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/"
    const val IMG_SQUARE_URL  = "https://ddragon.leagueoflegends.com/cdn/14.24.1/img/champion/"
    const val IMG_PASSIVE_URL = "https://ddragon.leagueoflegends.com/cdn/14.24.1/img/passive/"
    const val IMG_ABILITY_URL = "https://ddragon.leagueoflegends.com/cdn/14.24.1/img/spell/"
}

class ApiRepositoryImpl(
    private val httpClient: HttpClient
): ApiRepository {

    override suspend fun getAllChampions(): ApiResponse<ChampionResponseModel> =
        httpClient
            .getApiResponse("champion.json")

    override suspend fun getChampionByName(name: String): ApiResponse<ChampionResponseModel> =
        httpClient
            .getApiResponse("champion/$name.json")
}