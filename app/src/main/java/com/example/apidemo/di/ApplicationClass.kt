package com.example.apidemo.di

import android.app.Application

class ApplicationClass:Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
         applicationComponent = DaggerApplicationComponent.builder( ).build()
    }
}