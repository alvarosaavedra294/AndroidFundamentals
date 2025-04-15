package com.example.day1.retrofit

import com.example.day1.retrofit.models.User
import retrofit2.Call
import retrofit2.http.GET

interface ExamplesApi {


    @GET("users")
    fun getUsers():Call<List<User>>
}