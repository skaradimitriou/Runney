package com.stathis.runney.features.dashboard.home.adapter

import androidx.databinding.ViewDataBinding
import com.stathis.runney.BR
import com.stathis.runney.abstraction.AbstractViewHolder
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.HomeScreenCallback
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.features.dashboard.home.model.HomeItem

class HomeViewHolder(val binding : ViewDataBinding,val callback : ItemClickListener) : AbstractViewHolder(binding) {

    override fun present(data: LocalModel){
        when(data){
            is HomeItem -> {
                binding.setVariable(BR.item,data)
                binding.setVariable(BR.callback,callback)
            }
        }
    }
}