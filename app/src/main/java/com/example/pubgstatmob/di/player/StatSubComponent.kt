package com.example.pubgstatmob.di.player

import com.example.pubgstatmob.ui.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [StatModule::class])
interface ActivityViewModelComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun componentActivity(activity: MainActivity): Builder
        fun build(): ActivityViewModelComponent
    }

    fun inject(activity: MainActivity)
}