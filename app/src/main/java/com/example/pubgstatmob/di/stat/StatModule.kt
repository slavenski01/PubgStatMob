package com.example.pubgstatmob.di.stat

import androidx.lifecycle.ViewModelProvider
import com.example.pubgstatmob.data.api.StatPlayerApi
import com.example.pubgstatmob.data.stat.StatRepo
import com.example.pubgstatmob.data.stat.StatRepoImpl
import com.example.pubgstatmob.presentation.StatViewModel
import com.example.pubgstatmob.presentation.StatViewModelFactory
import com.example.pubgstatmob.ui.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StatModule {

    @Provides
    @ActivityScope
    fun provideViewModel(activity: MainActivity, repository: StatRepo) =
        ViewModelProvider(
            activity.viewModelStore,
            StatViewModelFactory(repository)
        ).get(StatViewModel::class.java)

    @Provides
    @ActivityScope
    fun provideStatRepo(statPlayerApi: StatPlayerApi): StatRepo = StatRepoImpl(statPlayerApi)
}