package com.example.day1.retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day1.R
import com.example.day1.databinding.ActivityUsersBinding
import com.example.day1.retrofit.models.User
import retrofit2.Callback

class UsersActivity : AppCompatActivity() {
    lateinit var binding: ActivityUsersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUsersBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.loadButton.setOnClickListener {

            loadUsers()
        }
    }

    fun loadUsers() {
        RetrofitInstances.service.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(
                call: retrofit2.Call<List<User>>,
                response: retrofit2.Response<List<User>>
            ) {

                if (response.isSuccessful) {
                    response.body()?.let { users ->
                       users.forEach {
                           Log.d("User", it.toString())
                       }
                    }
                } else {

                }
            }

            override fun onFailure(call: retrofit2.Call<List<User>>, t: Throwable) {

            }
        })
    }
}