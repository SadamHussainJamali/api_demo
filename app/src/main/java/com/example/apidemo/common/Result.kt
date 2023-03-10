package com.example.apidemo.common


import okhttp3.ResponseBody
import retrofit2.Response


sealed class Result {
    class Success(var body: Any?) : Result()
    class Error(val errorBody: Response<ResponseBody>) : Result()
    class Exception(val exception: java.lang.Exception) : Result()
}