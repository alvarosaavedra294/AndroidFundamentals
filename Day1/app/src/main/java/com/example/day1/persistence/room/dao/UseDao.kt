package com.example.day1.persistence.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.day1.persistence.room.models.UserEntity

@Dao
interface UseDao {

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM user")
    fun getAllUsersLiveData(): LiveData<List<UserEntity>>

    @Query("INSERT INTO user (name, lastName, email) VALUES (:name, :lastName, :email)")
    suspend fun insertUser2(name: String, lastName: String, email: String)

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}