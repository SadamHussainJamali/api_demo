package com.example.apidemo

import com.example.apidemo.network.NetworkCalls

class DemoRepository {
    /*repository do have access to local data,
    but for this demo I am not adding it here.
    and also the repository decides weather to bring data from local or network.
     */
    val networkCalls = NetworkCalls()

    suspend fun getQuotes() = networkCalls.getQuotes()
}