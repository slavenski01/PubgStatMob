package com.example.pubgstatmob

import android.app.Application
import com.example.pubgstatmob.di.ApplicationComponent
import com.example.pubgstatmob.di.DaggerApplicationComponent

class MainApp : Application() {
    companion object {
        val applicationComponent: ApplicationComponent by lazy {
            DaggerApplicationComponent.create()
        }
    }
}