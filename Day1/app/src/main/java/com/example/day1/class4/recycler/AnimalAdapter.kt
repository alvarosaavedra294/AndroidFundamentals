package com.example.day1.class4.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.day1.class4.recycler.models.Animal
import com.example.day1.databinding.ItemAnimalBinding

class AnimalAdapter(val listener:AnimalListener, val list:MutableList<Animal>) : Adapter<AnimalAdapter.AnimalViewHolder>() {



    class AnimalViewHolder(val binding: ItemAnimalBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val layourInflater = LayoutInflater.from(parent.context)
        val itemAnimalBinding = ItemAnimalBinding.inflate(layourInflater, parent, false)
        return AnimalViewHolder(itemAnimalBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val item = list[position]

        if (item.url.isNotEmpty()){
            Glide.with(holder.binding.root.context)
                .load(item.url)
                .into(holder.binding.animalImage)
        }else {
            holder.binding.animalImage.setImageResource(item.imageId)
        }

        holder.binding.deleteIcon.setOnClickListener {
            deleteAnimal(item)
        }
        holder.binding.animalCard.setOnClickListener {
            listener.onTapAnimal(item)
        }
    }

    fun deleteAnimal(item:Animal){
        val index = list.indexOf(item)
        if (index != -1 ){
            list.removeAt(index )
            notifyItemRemoved(index )
        }
    }

    fun addAnimal(animal: Animal) {
        list.add(animal)
//        notifyDataSetChanged()
        notifyItemInserted(list.size - 1)
    }


}