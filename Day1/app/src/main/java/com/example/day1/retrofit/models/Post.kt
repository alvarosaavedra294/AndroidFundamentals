package com.example.day1.retrofit.models

import com.google.gson.annotations.SerializedName

data class Post(
    val id: Int? = null,
    val title: String,
    @SerializedName("body")
    val description: String,
    @SerializedName("userId")
    val userId: Int
)
//title: 'foo',
//body: 'bar',
//userId: 1,