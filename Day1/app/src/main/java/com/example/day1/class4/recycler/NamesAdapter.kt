package com.example.day1.class4.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.day1.databinding.SimpleItemBinding

class NamesAdapter(val nameList:List<String>):Adapter<NamesAdapter.NameViewHolder>() {



    class NameViewHolder(val binding:SimpleItemBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val simpleItemBinding = SimpleItemBinding.inflate(layoutInflater, parent, false)
        return NameViewHolder(simpleItemBinding)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
       holder.binding.mainText.text = nameList[position]
    }
}