package com.example.apidemo.network

import com.example.apidemo.common.Result
import com.example.apidemo.retrofit.RetrofitObject


class NetworkCalls() {

    //get quote api call a getMethod which is generalize and can handle any get request

    suspend fun getQuotes(): Result {
        return RetrofitObject.get(GET_QUOTE, false, null)
    }
}