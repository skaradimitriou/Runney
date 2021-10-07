package com.stathis.runney.features.dashboard.search

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.SearchScreenCallback
import com.stathis.runney.features.dashboard.search.adapter.SearchAdapter
import com.stathis.runney.models.SearchCategory

class SearchViewModel : ViewModel(), SearchScreenCallback {

    val adapter = SearchAdapter(this)
    val data = MutableLiveData<List<LocalModel>>()
    private lateinit var callback: SearchScreenCallback

    init {
        getUserQueries()
    }

    private fun getUserQueries() {
        data.value = emptyList()
    }

    private fun searchForQuery(string: String){
        //FIXME: Implement Logic
        data.value = emptyList()
    }

    fun observe(owner : LifecycleOwner){
        data.observe(owner, Observer{
            adapter.submitList(it)
        })
    }

    fun release(owner : LifecycleOwner){
        data.removeObservers(owner)
    }

    fun addCallbacks(callback: SearchScreenCallback) {
        this.callback = callback
    }

    override fun onCategoryTap(category: SearchCategory) = callback.onCategoryTap(category)
}