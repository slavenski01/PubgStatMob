package com.example.pubgstatmob.data.api

import com.example.pubgstatmob.data.models.PlayerApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayerApi {
    @GET("players")
    suspend fun getPlayerStat(@Query("filter[playerNames]") name: String): Response<PlayerApiModel>
}