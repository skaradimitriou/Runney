package com.stathis.runney.features.dashboard.search.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.BR
import com.stathis.runney.abstraction.AbstractViewHolder
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.callbacks.SearchScreenCallback
import com.stathis.runney.databinding.HolderSearchCategoryItemBinding
import com.stathis.runney.models.Query

class SearchViewHolder(val binding : ViewDataBinding,val callback : ItemClickListener) : AbstractViewHolder(binding) {

    override fun present(data : LocalModel){
        when(data){
            is Query ->  {
                binding.setVariable(BR.query,data)
                binding.setVariable(BR.callback,callback)
            }
        }
    }
}