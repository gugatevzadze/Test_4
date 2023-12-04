package com.example.test_4

import androidx.fragment.app.viewModels
import com.example.homework_14.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()
    private val chatListAdapter = ChatListAdapter()

    override fun setUp() {
        //couldnt implement the logic here
    }

    override fun onClickListeners() {
        //couldnt implement the logic here
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.searchChat(it)
                }
                return true
            }
        })
    }

    override fun bindObservers() {
        //couldnt implement the logic here
    }
}