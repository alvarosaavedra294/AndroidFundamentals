package com.example.day1.class3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day1.R
import com.example.day1.databinding.ActivityConditionalsBinding

class ConditionalsActivity : AppCompatActivity() {

    lateinit var binding: ActivityConditionalsBinding

    private val TAG = "ConditionalsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityConditionalsBinding.inflate(layoutInflater)
        Log.d(TAG, "onCreate called")
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //checkAnimal(Animal.MAMMAL)

        checkPerson()

        binding.countButton.setOnClickListener {
            MySingleton.count++
        }

        binding.refreshButton.setOnClickListener {
            Log.d(TAG, "Count: ${MySingleton.count}")
        }

        binding.nextButton.setOnClickListener {
            navigateToNextActivity()
        }
        binding.webButton.setOnClickListener {
//            goToWeb()
            startActivity(sendMessageIntent)
        }

    }

    private fun navigateToNextActivity() {

        val nextIntent = Intent(this, EmptyActivity::class.java)

        nextIntent.putExtra("MY_KEY","Jhon Doe")

        startActivity(nextIntent)

    }

    private fun goToWeb(){
        val webIntent = Intent(Intent.ACTION_VIEW)
        webIntent.data = Uri.parse("https://www.google.com")
        startActivity(webIntent)
    }

    val sendMessageIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "Hello world")
        type = "text/plain"
    }


    private fun checkPerson() {
        val person1 = Person("Pedro", 20)
        val person2 = Person("Pedro", 20)

        if (person1 == person2) {
            Log.d(TAG, "Person 1 and Person 2 are the same")
        } else {
            Log.d(TAG, "Person 1 and Person 2 are different")
        }

        val people1 = People()
        val people2 = People()

        if (people1 == people2) {
            Log.d(TAG, "People 1 and People 2 are the same")
        } else {
            Log.d(TAG, "People 1 and People 2 are different")
        }


    }

    fun checkAnimal(animal: Animal) {
        when (animal) {
            Animal.CAT -> Log.d(TAG, "It's a cat")
            Animal.DOG -> Log.d(TAG, "It's a dog")
            Animal.FISH -> Log.d(TAG, "It's a fish")
            Animal.BIRD -> Log.d(TAG, "It's a bird")
            Animal.REPTILE -> Log.d(TAG, "It's a reptile")
            else -> Log.e(TAG, "Unknown animal", Exception("Unknown animal"))
        }
    }

    fun checkNumber(number: Int) {
        when (number) {
            5 -> println("Number is 5")
            in 1..10 -> println("Number is between 1 and 10")
            in 11..20 -> println("Number is between 11 and 20")
            else -> println("Number is out of range")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}