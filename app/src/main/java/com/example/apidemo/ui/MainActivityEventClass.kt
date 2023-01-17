package com.example.apidemo.ui

import com.example.apidemo.pojo_class.Quotes

sealed class MainActivityEventClass{
    class ShowQuotes(val quotes: Quotes ):MainActivityEventClass()
    object backButtonPressed : MainActivityEventClass()

    class ShowExceptionAndErrors(val message:String): MainActivityEventClass()
}
