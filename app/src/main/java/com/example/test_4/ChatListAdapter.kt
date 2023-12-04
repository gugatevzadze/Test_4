package com.example.test_4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_14.databinding.ChatItemBinding

class ChatListAdapter:ListAdapter<ChatItem, ChatListAdapter.ChatItemViewholder>(ChatItemDiffCallback()) {

    inner class ChatItemViewholder(val binding: ChatItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatItemViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ChatItemBinding.inflate(inflater, parent, false)
        return ChatItemViewholder(binding)
    }

    override fun onBindViewHolder(holder: ChatItemViewholder, position: Int) {
    }

    private class ChatItemDiffCallback:DiffUtil.ItemCallback<ChatItem>(){
        override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
        return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
        return oldItem == newItem
        }
    }
}