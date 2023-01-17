package com.example.apidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.apidemo.databinding.ActivityMainBinding
import com.example.apidemo.ui.MainActivityEventClass

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var viewModel:MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel =  ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setObservers()
        initializeViews()
        setContentView(binding.root)
    }

    private fun initializeViews() {
        //initializing recycler view and other views.
    }

    private fun setObservers() {
        viewModel.eventsObs.observe(this) {
            val event = it.getEventIfNotHandled()
            when (event) {
                is MainActivityEventClass.ShowQuotes -> {
                    Log.i("show_quotes", event.quotes.toString())
                    //todo we can show the data into recyclerview or in other view
//                    Toast.makeText(this,viewModel.text,Toast.LENGTH_LONG).show()
                }
                MainActivityEventClass.backButtonPressed->{

                }

                is MainActivityEventClass.ShowExceptionAndErrors-> Toast.makeText(this,
                    event.message,Toast.LENGTH_LONG).show()
                else -> {}
            }
        }
    }
}