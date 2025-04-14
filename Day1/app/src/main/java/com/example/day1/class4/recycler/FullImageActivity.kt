package com.example.day1.class4.recycler

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day1.R
import com.example.day1.class4.recycler.models.Data
import com.example.day1.databinding.ActivityFullImageBinding

class FullImageActivity : AppCompatActivity() {

    lateinit var binding: ActivityFullImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullImageBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val imageId: Int = intent.getIntExtra("imageId", 0)
        val data: Data? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("data", Data::class.java)
        } else {
            intent.getParcelableExtra("data")
        }
        if (imageId != 0) {
            binding.fullImage.setImageResource(imageId)
        }
        Log.d("FullImageActivity", data?.name ?: "no data ")
    }
}