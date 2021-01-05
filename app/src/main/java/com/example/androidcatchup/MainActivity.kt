package com.example.androidcatchup

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

// https://developer.android.com/kotlin/flow#collect
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
//            flowValue().collect { value ->
//                Log.d("MainActivity", value)
//            }

            flowValue().onEach {
                Log.d("MainActivity", it)
            }
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