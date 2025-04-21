package com.example.day1.persistence

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.day1.persistence.room.RoomDB
import com.example.day1.persistence.room.UserRepository

class PreferenceViewModel(application: Application) : AndroidViewModel(application) {

    private val db = RoomDB.getDatabase(application)
    private val userRepository = UserRepository(db.userDao())

    val userList = db.userDao().getAllUsersLiveData()

    suspend fun getAllUsers() = userRepository.getAllUsers()

}