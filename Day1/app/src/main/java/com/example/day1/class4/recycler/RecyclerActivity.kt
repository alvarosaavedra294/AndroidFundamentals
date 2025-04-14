package com.example.day1.class4.recycler

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.day1.R
import com.example.day1.class4.recycler.models.Animal
import com.example.day1.class4.recycler.models.Data
import com.example.day1.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity(), AnimalListener {
    lateinit var binding: ActivityRecyclerBinding
    lateinit var adapter: AnimalAdapter
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


        adapter = AnimalAdapter(this, Mock.getImageList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
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
        fullImageIntent.putExtra("data", Data("Hello"))

        startActivity(fullImageIntent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dog_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        when (item.itemId) {
            R.id.sort -> {
                Toast.makeText(this, "Sort", Toast.LENGTH_LONG).show()
            }

            R.id.info -> {
                Toast.makeText(this, "info", Toast.LENGTH_LONG).show()

            }

            R.id.delete -> {
                Toast.makeText(this, "delete", Toast.LENGTH_LONG).show()

            }

            else -> {
                Toast.makeText(this, "other", Toast.LENGTH_LONG).show()

            }
        }
        return super.onOptionsItemSelected(item)
    }


}