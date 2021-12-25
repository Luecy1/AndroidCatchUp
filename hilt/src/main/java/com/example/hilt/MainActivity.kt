package com.example.hilt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var simpleClass: SimpleClass

    @Inject
    lateinit var complexClass: ComplexClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // simpleClassが使える
        Log.d("@@@", simpleClass.getString())

        // complexClassが使える
        Log.d("@@@", complexClass.getString())

        val nonHiltClass = NonHiltClass(applicationContext)
        nonHiltClass.useSimpleClass()
    }
}