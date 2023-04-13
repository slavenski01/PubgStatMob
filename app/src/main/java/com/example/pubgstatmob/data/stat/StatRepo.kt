package com.example.pubgstatmob.data.stat

import retrofit2.Response

interface StatRepo {
    suspend fun getPlayerStat(): Response<String>
}