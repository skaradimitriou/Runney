package com.stathis.runney.features.dashboard.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.abstraction.AbstractFragment
import com.stathis.runney.callbacks.SearchScreenCallback
import com.stathis.runney.databinding.FragmentSearchBinding
import com.stathis.runney.models.Query
import com.stathis.runney.models.SearchCategory

class SearchFragment : AbstractFragment() {

    private lateinit var viewModel : SearchViewModel
    private lateinit var binding : FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun startOps() {
        manageSearch()
        binding.topicsRecycler.adapter = viewModel.adapter

        viewModel.addCallbacks(object : SearchScreenCallback {
            override fun onQueryTap(query: Query) = viewModel.getResultsForQuery(query.query)
        })

        viewModel.observe(this)
    }

    override fun stopOps() = viewModel.release(this)

    private fun manageSearch() {
        binding.searchSearchbar.setOnClickListener {
            binding.searchSearchbar.isIconified = false
        }

        binding.searchSearchbar.clearFocus()

        binding.searchSearchbar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchSearchbar.clearFocus()
                binding.searchSearchbar.setQuery("", false)

                viewModel.insertQueryToDb(Query(query.toString()))

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }
}