package com.example.day1.class4.recycler

import com.example.day1.R
import com.example.day1.class4.recycler.models.Animal

object Mock {

    fun getMockList(): MutableList<String> {
        val nameList = mutableListOf<String>()
        for (i in 1..1000) {
            val name = "Name $i"
            nameList.add(name)
        }
        return nameList
    }


    fun getImageList(): MutableList<Animal>{
        return mutableListOf(
            Animal("1", R.drawable.pic1, "https://random-d.uk/api/260.jpg"),
            Animal("2", R.drawable.pic2),
            Animal("3", R.drawable.pic3),
            Animal("4", R.drawable.pic4),
            Animal("5", R.drawable.pic5),
            Animal("6", R.drawable.pic6),
            Animal("7", R.drawable.pic1),
            Animal("8", R.drawable.pic2),
            Animal("9", R.drawable.pic3),
            Animal("10", R.drawable.pic4),
            Animal("11", R.drawable.pic5),
            Animal("12", R.drawable.pic6),
        )

    }

}