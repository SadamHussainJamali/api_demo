package com.example.apidemo.network

import com.example.apidemo.common.Result
import com.example.apidemo.retrofit.RetrofitObject
import javax.inject.Inject


class NetworkCalls @Inject constructor(val networkCalls: RetrofitObject) {

    //get quote api call a getMethod which is generalize and can handle any get request

    suspend fun getQuotes(): Result {
        return networkCalls.get(GET_QUOTE, false, null)
    }
}