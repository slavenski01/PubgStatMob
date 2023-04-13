package com.example.pubgstatmob.data.api

import retrofit2.Response
import retrofit2.http.GET

interface StatPlayerApi {
    @GET("players?filter[playerNames]=slavenski")
    suspend fun getPlayerStat(): Response<String>
}