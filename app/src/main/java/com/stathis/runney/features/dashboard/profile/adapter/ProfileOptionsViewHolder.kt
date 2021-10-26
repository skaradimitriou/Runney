package com.stathis.runney.features.dashboard.profile.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.BR
import com.stathis.runney.abstraction.AbstractViewHolder
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.callbacks.ProfileOptionsCallback
import com.stathis.runney.databinding.HolderProfileOptionItemBinding
import com.stathis.runney.features.dashboard.profile.model.ProfileOption

class ProfileOptionsViewHolder(val binding : ViewDataBinding, val callback : ItemClickListener) : AbstractViewHolder(binding) {

    override fun present(data : LocalModel){
        when(data){
            is ProfileOption -> {
                binding.setVariable(BR.profileOption,data)
                binding.setVariable(BR.callback,callback)
            }
        }
    }
}