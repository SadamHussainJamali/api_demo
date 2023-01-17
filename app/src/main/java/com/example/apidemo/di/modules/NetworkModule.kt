package com.example.apidemo.di.modules

import com.example.apidemo.BuildConfig
import com.example.apidemo.network.retrofit.RetrofitApiRequests
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class  NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Singleton
    @Provides
    fun getAPIs(retrofit: Retrofit): RetrofitApiRequests = retrofit.create(RetrofitApiRequests::class.java)
}