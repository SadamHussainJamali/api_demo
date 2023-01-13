package com.example.apidemo

import com.example.apidemo.common.Result
import com.example.apidemo.pojo_class.Quotes
import com.google.gson.Gson

class DemoUseCaseForAPI {


    //we can provide repositories and other dependencies using dependencies-injection like dagger,
    // hilt or using other provider. but I am not using it for this demo.
    val repository = DemoRepository()
    val gson = Gson()

    /*if some manipulation is needed we can do here before passing data to viewModel
     and this use can be used any where in the app not only for the current screen.
     */
    suspend fun getQuotes(): Result {
        repository.getQuotes().let {
            if (it is Result.Success) {
                return Result.Success(gson.fromJson(it.body.toString(), Quotes::class.java))
            } else return it
        }
    }


}