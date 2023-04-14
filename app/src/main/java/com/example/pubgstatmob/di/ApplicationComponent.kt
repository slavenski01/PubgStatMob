package com.example.pubgstatmob.di

import com.example.pubgstatmob.di.network.NetworkModule
import com.example.pubgstatmob.di.player.ActivityViewModelComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun activityViewModelComponentBuilder(): ActivityViewModelComponent.Builder
}