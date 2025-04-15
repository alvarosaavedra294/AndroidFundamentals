package com.example.day1.retrofit.models

import com.google.gson.annotations.SerializedName

data class User(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    @SerializedName("name")
    val customName: String,
    val phone: String,
    val username: String,
    val website: String
)