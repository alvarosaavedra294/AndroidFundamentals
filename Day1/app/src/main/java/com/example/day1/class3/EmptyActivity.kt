package com.example.day1.class3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day1.R
import com.example.day1.databinding.ActivityEmptyBinding

class EmptyActivity : AppCompatActivity() {

    lateinit var binding: ActivityEmptyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getData()
        binding.nextButton.setOnClickListener {
            val nextIntent = Intent(this, ConditionalsActivity::class.java)
            startActivity(nextIntent)
        }
    }

    private fun getData() {

        val name = intent.getStringExtra("MY_KEY")

//        binding.nameTextView.text = name
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("EmptyActivity", "onDestroy called")
    }
}