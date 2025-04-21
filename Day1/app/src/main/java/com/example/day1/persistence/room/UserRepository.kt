package com.example.day1.persistence.room

import android.service.autofill.UserData
import android.util.Log
import com.example.day1.persistence.room.dao.UseDao
import com.example.day1.persistence.room.models.UserEntity

class UserRepository(private val userDao: UseDao) {

    suspend fun getAllUsers():List<UserEntity>{
        val list = userDao.getAllUsers()
        list.forEach {
            Log.d("UserRepository","User: ${it.name} ${it.lastName} ${it.email}")
        }
        return list
    }
}