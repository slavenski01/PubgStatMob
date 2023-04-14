package com.example.pubgstatmob.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pubgstatmob.data.player.PlayerRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlayerViewModel(
    private val playerRepo: PlayerRepo
) : ViewModel() {

    fun getPlayerStat(playerName: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = playerRepo.getPlayerStat(playerName)
                Log.e("StatViewModel", "${response.body()}")
            }
        }
    }
}