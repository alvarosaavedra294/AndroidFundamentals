package com.example.day1.class4.navForResult

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day1.R
import com.example.day1.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    lateinit var binding: ActivityFormBinding
    var requestIsSuccess: Boolean = false

    val loginLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                requestIsSuccess = true
                returnData()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.doneButton.setOnClickListener {
            returnData()
        }
    }

    private fun returnData() {

        if (requestIsSuccess) {
            val name = binding.nameEditText.text.toString()
            val resultIntent = intent
            resultIntent.putExtra("name", name)
            setResult(RESULT_OK, resultIntent)
            finish()
        } else {
            loginLauncher.launch(Intent(this, LoginActivity::class.java))
        }


    }
}