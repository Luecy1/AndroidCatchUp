package com.example.androidcatchup

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// https://developer.android.com/kotlin/flow#collect
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            flowValue().collect {
                Log.d("MainActivity", it)
            }

            val repository = provideRepository()

            val items = repository.items().enqueue(object : Callback<Item> {
                override fun onResponse(call: Call<Item>?, response: Response<Item>?) {
                    Log.d("MainActivity", response?.body().toString())
                }

                override fun onFailure(call: Call<Item>?, t: Throwable?) {
                    TODO("Not yet implemented")
                }
            })
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