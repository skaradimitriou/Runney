package com.stathis.runney.features.dashboard.profile.adapter

import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ProfileOptionsCallback
import com.stathis.runney.databinding.HolderProfileOptionItemBinding
import com.stathis.runney.features.dashboard.profile.model.ProfileOption

class ProfileOptionsViewHolder(val binding : HolderProfileOptionItemBinding, val callback : ProfileOptionsCallback) : RecyclerView.ViewHolder(binding.root) {

    fun present(data : LocalModel){
        when(data){
            is ProfileOption -> {
                binding.profileOption = data
                binding.root.setOnClickListener { callback.onOptionTap(data) }
            }
        }
    }
}