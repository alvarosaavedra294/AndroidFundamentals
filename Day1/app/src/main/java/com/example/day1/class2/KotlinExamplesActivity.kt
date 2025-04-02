package com.example.day1.class2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day1.R
import com.example.day1.databinding.ActivityKotlinExamplesBinding

class KotlinExamplesActivity : AppCompatActivity() {

    lateinit var binding: ActivityKotlinExamplesBinding

    var dog: String? = null
    var cat: String = "Black"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKotlinExamplesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        cat = "asdf"
        dog = "Toby"


        binding.myButton.setOnClickListener {
            //updateText("Juan", "Perez", 20)
            updateText(age = 18, name = "Juan")
           // updateText()
        }

        binding.myButton2.setOnClickListener {
            binding.secondSection.visibility = View.VISIBLE
        }
    }

    private fun updateText(name: String = "Pedro", lastname:String = "Perez", age: Int = 18) {
        // binding.myText.text = "Hello World " + name
//        binding.myText.text = getString(R.string.hello_world_name, name)
        binding.myText.text = "${getString(R.string.hello_world)} $name"
        //  binding.myText.text = "Hello World ${name.length + 8 }"
    }

    override fun onResume() {
        super.onResume()

//        if (dog != null){
//            dog = null
//            dog.length
//        }

        dog?.let { mydog ->
            mydog.length
        }
        val otherDog: String = dog ?: "No dog"
    }
}