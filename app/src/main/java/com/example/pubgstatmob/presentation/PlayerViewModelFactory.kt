package com.example.pubgstatmob.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pubgstatmob.data.player.PlayerRepo
import javax.inject.Inject

class PlayerViewModelFactory @Inject constructor(private val repository: PlayerRepo) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlayerViewModel(repository) as T
    }
}