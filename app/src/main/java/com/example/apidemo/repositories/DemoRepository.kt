package com.example.apidemo.repositories

import com.example.apidemo.network.NetworkCalls
import javax.inject.Inject

class DemoRepository @Inject constructor(val networkCalls:NetworkCalls){
    /*repository do have access to local data,
    but for this demo I am not adding it here.
    and also the repository decides weather to bring data from local or network.
     */

    suspend fun getQuotes() = networkCalls.getQuotes()
}