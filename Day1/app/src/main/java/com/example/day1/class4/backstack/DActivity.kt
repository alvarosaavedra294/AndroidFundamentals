package com.example.day1.class4.backstack

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day1.R
import com.example.day1.databinding.ActivityAactivityBinding

class DActivity : AppCompatActivity() {
    lateinit var binding: ActivityAactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.nameTextView.text = "Activity D"
        binding.navigationButton.setOnClickListener {
            navigate()
        }
    }

    fun navigate(){
        val intentToNew = Intent(this, CActivity::class.java)
//        intentToNew.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intentToNew)
    }
}