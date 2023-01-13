package com.example.apidemo.retrofit

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface RetrofitApiRequests {
    //Creating GET/POST request

    @GET
    suspend fun get(@Url endpoint: String): Response<ResponseBody>

    @GET
    suspend fun get(
        @Url endpoint: String,
        @HeaderMap headerMap: @JvmSuppressWildcards Map<String, String>
    ): Response<ResponseBody>

    @GET
    suspend fun get(
        @Url endpoint: String,
        @HeaderMap headers: @JvmSuppressWildcards Map<String, String>,
        @QueryMap query: @JvmSuppressWildcards Map<String, String>
    ): Response<ResponseBody>
}