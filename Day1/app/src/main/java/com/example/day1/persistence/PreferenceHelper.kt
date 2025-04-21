package com.example.day1.persistence

import android.content.Context

class PreferenceHelper(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

    fun saveValue(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun saveName(value: String){
        sharedPreferences.edit().putString("com.example.day1.name", value).apply()
    }

    fun getName(): String? {
        return sharedPreferences.getString("com.example.day1.name", null)
    }

    fun getValue(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun saveIntValue(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}