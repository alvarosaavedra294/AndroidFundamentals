package com.example.day1.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day1.R
import com.example.day1.databinding.ActivityFatherBinding

class FatherActivity : AppCompatActivity() {
    lateinit var binding: ActivityFatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fragmentC = CFragment()
        val myArguments = Bundle()
        myArguments.putString("parent", "from FatherActivity")
        fragmentC.arguments = myArguments
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentCContainer, fragmentC)
            .addToBackStack("fragmentC")
            .commit()




        binding.addFragmentButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentCContainer, AFragment())
                .addToBackStack("fragmentA")
                .commit()
        }

    }
}