package com.example.day1.persistence

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day1.R
import com.example.day1.databinding.ActivityPreferenceBinding
import com.example.day1.persistence.room.RoomDB
import com.example.day1.persistence.room.models.UserEntity
import kotlinx.coroutines.launch

class PreferenceActivity : AppCompatActivity() {

    lateinit var binding: ActivityPreferenceBinding
    lateinit var preferenceHelper: PreferenceHelper
    lateinit var viewModel: PreferenceViewModel
    lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewModel = PreferenceViewModel(this.application)
        binding = ActivityPreferenceBinding.inflate(layoutInflater)
        adapter = UserAdapter()
        setContentView(binding.root)
        preferenceHelper = PreferenceHelper(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recoverName()
        binding.saveButton.setOnClickListener {

            saveValue(binding.nameEditText.text.toString())
        }

        binding.recoverButton.setOnClickListener {
            recoverName()
        }

        binding.saveButtonDb.setOnClickListener {
            saveInDb(binding.userNameEditText.text.toString())
        }
        binding.recoverButtonDb.setOnClickListener {
//            recoverFromDb()
            lifecycleScope.launch {
                val list = viewModel.getAllUsers()

            }
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        viewModel.userList.observe(this) {
            it.forEach {
                Log.d("PreferenceActivity", "onCreate: ${it.name} ${it.lastName} ${it.email}")
            }
            adapter.setUserList(it)

        }
    }

    fun saveInDb(name: String) {
        val userEntity = UserEntity(
            name = name,
            lastName = "lastName",
            email = "email"
        )
        lifecycleScope.launch {
            RoomDB.getDatabase(this@PreferenceActivity).userDao().insertUser(userEntity)
        }
    }

    fun recoverFromDb() {
        lifecycleScope.launch {
            val list = RoomDB.getDatabase(this@PreferenceActivity).userDao().getAllUsers()
            list.forEach {
                Log.d("PreferenceActivity", "recoverFromDb: ${it}")
            }
        }
    }

    private fun recoverName() {

        val name = preferenceHelper.getName() ?: "no Name"
        binding.nameEditText.setText(name)
    }

    private fun saveValue(toString: String) {
        preferenceHelper.saveName(toString)
    }
}