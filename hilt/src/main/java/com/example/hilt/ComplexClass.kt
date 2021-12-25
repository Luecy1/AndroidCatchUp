package com.example.hilt

import android.content.Context
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

// 複雑なクラス（Roomインスタンスのように、自前でconstructorに@Injectをつけられないクラス）
class ComplexClass {

    fun getString(): String = "ComplexClass"
}

@Module
@InstallIn(SingletonComponent::class)
object ComplexClassModule {
    @Provides
    fun provideComplexClass(@ApplicationContext context: Context): ComplexClass {
        Log.d("@@@", context.toString())
        return ComplexClass()
    }
}