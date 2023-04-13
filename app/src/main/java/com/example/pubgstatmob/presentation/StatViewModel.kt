package com.example.pubgstatmob.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pubgstatmob.data.stat.StatRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StatViewModel(
    private val statRepo: StatRepo
) : ViewModel() {

    fun getPlayerStat() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = statRepo.getPlayerStat()
                Log.e("StatViewModel", "${response.body()}")
            }
        }
    }
}