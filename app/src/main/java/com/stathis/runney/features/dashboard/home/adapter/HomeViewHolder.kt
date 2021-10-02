package com.stathis.runney.features.dashboard.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.HomeScreenCallback
import com.stathis.runney.databinding.HolderHomeOptionItemBinding
import com.stathis.runney.features.dashboard.home.model.HomeItem

class HomeViewHolder(val binding : HolderHomeOptionItemBinding, val callback : HomeScreenCallback) : RecyclerView.ViewHolder(binding.root) {

    fun present(data: LocalModel){
        when(data){
            is HomeItem -> {
                binding.item = data
                binding.parent.setOnClickListener{ callback.onHomeItemTap(data) }
            }
        }
    }
}