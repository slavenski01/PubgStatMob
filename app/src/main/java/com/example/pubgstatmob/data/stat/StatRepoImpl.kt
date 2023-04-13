package com.example.pubgstatmob.data.stat

import com.example.pubgstatmob.data.api.StatPlayerApi
import javax.inject.Inject

class StatRepoImpl @Inject constructor(
    private val statPlayerApi: StatPlayerApi
) : StatRepo {
    override suspend fun getPlayerStat() = statPlayerApi.getPlayerStat()
}