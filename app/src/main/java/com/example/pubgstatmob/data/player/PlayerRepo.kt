package com.example.pubgstatmob.data.player

import com.example.pubgstatmob.data.models.PlayerApiModel
import retrofit2.Response

interface PlayerRepo {
    suspend fun getPlayerStat(playerName: String): Response<PlayerApiModel>
}