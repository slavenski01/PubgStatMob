package com.example.pubgstatmob.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pubgstatmob.data.stat.StatRepo
import javax.inject.Inject

class StatViewModelFactory @Inject constructor(private val repository: StatRepo) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StatViewModel(repository) as T
    }
}