package com.example.day1.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstances {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: ExamplesApi by lazy {
        retrofit.create(ExamplesApi::class.java)
    }


}