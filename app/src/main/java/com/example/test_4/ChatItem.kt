package com.example.test_4

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChatItem(
    val id: Int,
    val image: String?,
    val owner: String,
    val lastMessage: String,
    val lastActive: String,
    val unreadMessages: Int,
    val isTyping: Boolean,
    val lastMessageType: ItemType
){
    enum class ItemType {
        TEXT, FILE, VOICE
    }
}
