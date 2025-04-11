package com.example.day1.class4.recycler

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.day1.R
import com.example.day1.class4.recycler.models.Animal
import com.example.day1.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity(), AnimalListener {
    lateinit var binding: ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = AnimalAdapter(this, Mock.getImageList())
//        binding.recyclerView.adapter = NamesAdapter(Mock.getMockList())

        binding.addButton.setOnClickListener {
            val newAnimal = Mock.getImageList().random()
//            (binding.recyclerView.adapter as AnimalAdapter).addAnimal(newAnimal)

            (binding.recyclerView.adapter as AnimalAdapter).addAnimal(animal = newAnimal)

        }
    }

    override fun onTapAnimal(animal: Animal) {
        val fullImageIntent = Intent(this, FullImageActivity::class.java)
        fullImageIntent.putExtra("imageId", animal.imageId)
        startActivity(fullImageIntent)
    }
}