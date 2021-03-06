package com.example.androidcatchup

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


fun provideRepository(): Repository {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    return Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(Repository::class.java)
}

interface Repository {

    @GET("/todos/1")
    suspend fun items(): Item

    @GET("/todos/1")
    suspend fun itemsFlow(): Flow<Item>

}

data class Item(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)