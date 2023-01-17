package com.example.apidemo.di

import com.example.apidemo.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [NetworkModule::class ] )
interface  ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}