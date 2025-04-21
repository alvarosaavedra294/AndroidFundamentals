package com.example.day1.persistence

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.day1.databinding.ItemUserBinding
import com.example.day1.persistence.room.models.UserEntity

class UserAdapter:RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserEntity) {
            binding.userName.text = user.name
            binding.userLastName.text = user.lastName
            binding.userEmail.text = user.email
        }
    }

    private var userList: List<UserEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setUserList(users: List<UserEntity>) {
        this.userList = users
        notifyDataSetChanged()
    }
}