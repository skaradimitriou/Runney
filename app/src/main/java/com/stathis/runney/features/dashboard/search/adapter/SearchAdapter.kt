package com.stathis.runney.features.dashboard.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.runney.abstraction.DiffUtilClass
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.callbacks.SearchScreenCallback
import com.stathis.runney.databinding.HolderSearchCategoryItemBinding

class SearchAdapter(val callback : ItemClickListener) : ListAdapter<LocalModel,SearchViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = HolderSearchCategoryItemBinding.inflate(LayoutInflater.from(parent.context))
        return SearchViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) = holder.bindData(getItem(position))
}