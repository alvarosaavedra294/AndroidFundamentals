package com.example.day1.retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day1.R
import com.example.day1.class1.MainActivity
import com.example.day1.databinding.ActivityUsersBinding
import com.example.day1.databinding.CustomDialogBinding
import com.example.day1.dialogs.CustomDialogFragment
import com.example.day1.dialogs.CustomDialogListener
import com.example.day1.retrofit.models.Post
import com.example.day1.retrofit.models.User
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Callback

class UsersActivity : AppCompatActivity(), CustomDialogListener {
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

//            showMaterialAlertDialog()
//            customAlertDialog()
            showCustomDialogFragment()
        }

        binding.createButton.setOnClickListener {
            createPost()
        }
        binding.deleteButton.setOnClickListener {
            deletePost()
//            queryPost()
        }
        binding.activityDialogButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }


    private fun showCustomDialogFragment(){
        val customDialogFragment = CustomDialogFragment()
        customDialogFragment.show(supportFragmentManager, "CustomDialog")
    }

    private fun customAlertDialog(){
        val customView = CustomDialogBinding.inflate(layoutInflater, null, false)

        customView.mainText.text = "Do you like to load users?"
        MaterialAlertDialogBuilder(this)
            .setView(customView.root)
            .setPositiveButton("OK") { dialog, _ ->
                val value = customView.nameEditText.text.toString()
                Toast.makeText(this, value, Toast.LENGTH_LONG).show()
                loadUsers()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showAlertDialog(){
        AlertDialog.Builder(this)
            .setTitle("Alert")
            .setMessage("Do you like to load users?")
            .setPositiveButton("OK") { dialog, _ ->
                loadUsers()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }


    private fun showMaterialAlertDialog(){
       MaterialAlertDialogBuilder(this)
            .setTitle("Alert")
            .setMessage("Do you like to load users?")
            .setPositiveButton("OK") { dialog, _ ->
                loadUsers()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun queryPost(){
        RetrofitInstances.service.queryPost(123, 456).enqueue(object : Callback<Unit> {
            override fun onResponse(
                call: retrofit2.Call<Unit>,
                response: retrofit2.Response<Unit>
            ) {
                if (response.isSuccessful) {
                    Log.d("Post", response.body().toString())
                } else {
                    Log.d("Post", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: retrofit2.Call<Unit>, t: Throwable) {
                Log.d("Post", "Failure: ${t.message}")
            }
        })
    }

    private fun deletePost() {
        RetrofitInstances.service.deletePostById(1).enqueue(object : Callback<Unit> {
            override fun onResponse(
                call: retrofit2.Call<Unit>,
                response: retrofit2.Response<Unit>
            ) {
                if (response.isSuccessful) {
                    Log.d("Post", "Deleted successfully")
                } else {
                    Log.d("Post", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: retrofit2.Call<Unit>, t: Throwable) {
                Log.d("Post", "Failure: ${t.message}")
            }
        })
    }


    private fun createPost() {
        RetrofitInstances.service.createPost(
            Post(
                title = "NewPost",
                description = "description body",
                userId = 1
            )
        ).enqueue(object : Callback<Post> {
            override fun onResponse(
                call: retrofit2.Call<Post>,
                response: retrofit2.Response<Post>
            ) {
                if (response.isSuccessful) {
                    Log.d("Post", response.body().toString())
                } else {
                    Log.d("Post", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: retrofit2.Call<Post>, t: Throwable) {
                Log.d("Post", "Failure: ${t.message}")
            }
        })
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

    override fun onNewNameEntered(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_LONG).show()

    }
}