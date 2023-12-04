package com.example.test_4

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_14.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import okio.buffer
import okio.source
import java.lang.ref.WeakReference

class MainViewModel(context: Context) : ViewModel() {
    private val _chatList = MutableStateFlow<List<ChatItem>>(emptyList())
    val chatList: SharedFlow<List<ChatItem>> = _chatList.asStateFlow()

    private val contextReference: WeakReference<Context> = WeakReference(context)

    init {
        loadDataFromJson()
    }

    private fun loadDataFromJson() {
        viewModelScope.launch {
            try {
                val context = contextReference.get()
                context?.let {
                    val inputStream = it.resources.openRawResource(R.raw.data_json)
                    val bufferedSource = inputStream.source().buffer()

                    val chatItemType =
                        Types.newParameterizedType(List::class.java, ChatItem::class.java)
                    val adapter: JsonAdapter<List<ChatItem>> =
                        Moshi.Builder().build().adapter(chatItemType)

                    _chatList.value = adapter.fromJson(bufferedSource) ?: emptyList()
                }
            } catch (e: Exception) {
                //implement error exception when you can
            }
        }
    }

    fun searchChat(query: String) {
        viewModelScope.launch {
            val filteredList = _chatList.value.filter {
                it.owner.contains(query, true) || it.lastMessage.contains(query, true)
            }
            _chatList.value = filteredList
        }
    }
    //explicitly called this as i passed context as a parameter, i dont know if that is correct way in the first place but for now i am gonna keep it this way
    override fun onCleared() {
        super.onCleared()
    }
}



