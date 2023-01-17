package com.example.apidemo.di.components

import com.example.apidemo.ui.MainActivity.MainActivity
import com.example.apidemo.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [NetworkModule::class ] )
interface  ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}