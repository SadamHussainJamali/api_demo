package com.example.apidemo.ui.main_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apidemo.usecases.DemoUseCaseForAPI
import javax.inject.Inject

class MainActivityViewModelFactory @Inject constructor(val getQuotesUseCase: DemoUseCaseForAPI):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(getQuotesUseCase) as T
    }
}