package com.example.day1.persistence.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.day1.persistence.room.dao.UseDao
import com.example.day1.persistence.room.models.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RoomDB : RoomDatabase() {

    abstract fun userDao(): UseDao

    companion object {
        const val DATABASE_NAME = "user_db"

        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getDatabase(context: Context): RoomDB {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = RoomDB::class.java,
                    name = "mydb"
                ).build()
                    .also {
                        INSTANCE = it
                    }
            }
        }

    }

}