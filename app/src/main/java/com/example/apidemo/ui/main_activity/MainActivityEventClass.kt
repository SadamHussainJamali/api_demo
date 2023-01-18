package com.example.apidemo.ui.main_activity

import com.example.apidemo.pojo_class.Quotes

sealed class MainActivityEventClass{
    class ShowQuotes(val quotes: Quotes ): MainActivityEventClass()
    object BackButtonPressed : MainActivityEventClass()

    class ShowExceptionAndErrors(val message:String): MainActivityEventClass()
}
