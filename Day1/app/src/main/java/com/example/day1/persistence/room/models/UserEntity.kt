package com.example.day1.persistence.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0,
    val name:String = "",
    val lastName:String = "",
    val email:String = "",
)