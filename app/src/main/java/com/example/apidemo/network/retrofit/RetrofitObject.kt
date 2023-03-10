package com.example.apidemo.network.retrofit
import android.util.Log
import com.example.apidemo.common.Result
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class  RetrofitObject @Inject constructor(val apiInterface: RetrofitApiRequests) {

    suspend inline fun get(
        endpoint: String, //end point
        headerWithToken: Boolean, //header params
        queryMap: Map<String, String>? //query params
    ): Result {

        var headerMap = getHeader(headerWithToken)



        return if (headerMap == null && queryMap == null)
            generalRequest { apiInterface.get(endpoint) }
        else if (queryMap == null)
            generalRequest { apiInterface.get(endpoint, headerMap!!) }
        else
            generalRequest { apiInterface.get(endpoint, headerMap!!, queryMap) }
    }


        inline fun generalRequest(
            request: () -> Response<ResponseBody>
        ): Result =
            try {

                var response = request()
                if (response.isSuccessful) {
                    var responseString = response.body()?.string() ?: ""
//                declaring another try/catch block to differentiate
//                connection exception from parsing exceptions
                    Result.Success(
//                        gson.fromJson(responseString, T::class.java)
                        responseString
                    )


                } else {
//            to handle response codes other than 200
                    Result.Error(response)
                }
            } catch (exception: Exception) {
//          this catch is like onFailure when we used callbacks
                Log.e("API Error", exception.message?:"exception but no message.")
                Result.Exception(exception)

            }

    fun getHeader(headerWithToken: Boolean): @JvmSuppressWildcards Map<String, String>? {
        //creating header params
        //Todo Local storage will provide token but right now I have not included it.
        return if (headerWithToken) mutableMapOf(
            "Authorization" to "Token_from_local_storage",
            "Accept" to "application/json"
        ) else mutableMapOf(
            "Accept" to "application/json"
        )
    }

}