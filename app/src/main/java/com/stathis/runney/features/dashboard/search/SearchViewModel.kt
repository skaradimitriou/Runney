package com.stathis.runney.features.dashboard.search

import androidx.lifecycle.ViewModel
import com.stathis.runney.callbacks.SearchScreenCallback
import com.stathis.runney.features.dashboard.search.adapter.SearchAdapter
import com.stathis.runney.models.SearchCategory

class SearchViewModel : ViewModel(), SearchScreenCallback {

    val adapter = SearchAdapter(this)
    private lateinit var callback: SearchScreenCallback

    init {
        getCategories()
    }

    private fun getCategories() {
        val list = listOf(
            SearchCategory("Latest News"),
            SearchCategory("Popular News"),
            SearchCategory("Running Races"),
            SearchCategory("Articles"),
        )

        adapter.submitList(list)
    }

    fun addCallbacks(callback: SearchScreenCallback) {
        this.callback = callback
    }

    override fun onCategoryTap(category: SearchCategory) = callback.onCategoryTap(category)
}