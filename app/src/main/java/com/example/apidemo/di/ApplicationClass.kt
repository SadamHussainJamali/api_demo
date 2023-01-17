package com.example.apidemo.di

import android.app.Application
import com.example.apidemo.di.components.ApplicationComponent

class ApplicationClass:Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
         applicationComponent = DaggerApplicationComponent.builder( ).build()
    }
}