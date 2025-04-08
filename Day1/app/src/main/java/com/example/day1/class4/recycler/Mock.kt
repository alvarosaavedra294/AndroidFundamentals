package com.example.day1.class4.recycler

object Mock {

    fun getMockList(): List<String> {
        val nameList = mutableListOf<String>()
        for (i in 1..1000) {
            val name = "Name $i"
            nameList.add(name)
        }
        return nameList
    }

}