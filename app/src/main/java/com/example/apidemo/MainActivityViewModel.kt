package com.example.apidemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apidemo.common.BaseEvent
import com.example.apidemo.common.Result
import com.example.apidemo.pojo_class.Quotes
import com.example.apidemo.ui.MainActivityEventClass
import kotlinx.coroutines.launch

class MainActivityViewModel:ViewModel() {
    //in real project we provide repository using dagger
    val getQuotesUseCase = DemoUseCaseForAPI()

    private val events = MutableLiveData<BaseEvent<MainActivityEventClass>>()
    val eventsObs:LiveData<BaseEvent<MainActivityEventClass>> = events

    val showLoader = MutableLiveData(true)
    var text = "HI"
    init {
        //load quotes
        getQuotes()
    }

      fun getQuotes(){

        viewModelScope.launch {
            showLoader.value = true
            try {
                when(val result =getQuotesUseCase.getQuotes()){

                    is Result.Success->{
                        val quotes = result.body as Quotes
                        events.value = BaseEvent(MainActivityEventClass.ShowQuotes(quotes))

                    }
                    is Result.Error->{
                    //we can show Error by toast or dialog depend on the
                    // requirement of the design and the type of error.

                    }
                   is Result.Exception->{
                    //show exception
                   }
                }
            }catch (e:Exception){
                e.printStackTrace()

            }finally {
                showLoader.value = false
            }
        }
    }
}