package com.example.apidemo.ui.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.apidemo.databinding.ActivityMainBinding
import com.example.apidemo.di.ApplicationClass
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

     @Inject
     lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        viewModel =  ViewModelProvider(this,viewModelFactory )[MainActivityViewModel::class.java]
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
                MainActivityEventClass.backButtonPressed ->{

                }

                is MainActivityEventClass.ShowExceptionAndErrors -> Toast.makeText(this,
                    event.message,Toast.LENGTH_LONG).show()
                else -> {}
            }
        }
    }
}