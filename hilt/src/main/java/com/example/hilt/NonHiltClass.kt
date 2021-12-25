package com.example.hilt

import android.content.Context
import android.util.Log
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

// hiltで管理できないクラスと仮定
class NonHiltClass(
    val context: Context
) {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface NonHiltEntryPoint {
        fun simpleClass(): SimpleClass
    }

    fun useSimpleClass() {

        val nonHiltEntryPoint =
            EntryPointAccessors.fromApplication(context, NonHiltEntryPoint::class.java)

        Log.d("@@@", nonHiltEntryPoint.simpleClass().getString())


    }

}