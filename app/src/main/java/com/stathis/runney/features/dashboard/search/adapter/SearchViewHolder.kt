package com.stathis.runney.features.dashboard.search.adapter

import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.SearchScreenCallback
import com.stathis.runney.databinding.HolderSearchCategoryItemBinding
import com.stathis.runney.models.Query

class SearchViewHolder(val binding : HolderSearchCategoryItemBinding,val callback : SearchScreenCallback) : RecyclerView.ViewHolder(binding.root) {

    fun present(data : LocalModel){
        when(data){
            is Query ->  {
                binding.query = data
                binding.parent.setOnClickListener { callback.onQueryTap(data) }
            }
        }
    }
}