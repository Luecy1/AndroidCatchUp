package com.example.androidcatchup

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

// https://developer.android.com/kotlin/flow#collect
class MainActivity : AppCompatActivity() {

    val viewModel: BlankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            flowValue().collect {
                Log.d("MainActivity", it)
            }

            val repository = provideRepository()

            val items = repository.items()
            Log.d("MainActivity", items.toString())
        }
    }

    private fun flowValue(): Flow<String> = flow {

        emit("0")
        emit("1")
        emit("2")
        emit("3")
        emit("4")
        delay(1000)
    }
}