package com.example.pubgstatmob.di.player

import androidx.lifecycle.ViewModelProvider
import com.example.pubgstatmob.data.api.PlayerApi
import com.example.pubgstatmob.data.player.PlayerRepo
import com.example.pubgstatmob.data.player.PlayerRepoImpl
import com.example.pubgstatmob.presentation.PlayerViewModel
import com.example.pubgstatmob.presentation.PlayerViewModelFactory
import com.example.pubgstatmob.ui.MainActivity
import dagger.Module
import dagger.Provides

@Module
class StatModule {

    @Provides
    @ActivityScope
    fun provideViewModel(activity: MainActivity, repository: PlayerRepo) =
        ViewModelProvider(
            activity.viewModelStore,
            PlayerViewModelFactory(repository)
        ).get(PlayerViewModel::class.java)

    @Provides
    @ActivityScope
    fun provideStatRepo(playerApi: PlayerApi): PlayerRepo = PlayerRepoImpl(playerApi)
}