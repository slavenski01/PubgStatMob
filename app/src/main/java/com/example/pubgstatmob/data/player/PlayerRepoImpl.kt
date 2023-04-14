package com.example.pubgstatmob.data.player

import com.example.pubgstatmob.data.api.PlayerApi
import javax.inject.Inject

class PlayerRepoImpl @Inject constructor(
    private val playerApi: PlayerApi
) : PlayerRepo {
    override suspend fun getPlayerStat(playerName: String) = playerApi.getPlayerStat(playerName)
}