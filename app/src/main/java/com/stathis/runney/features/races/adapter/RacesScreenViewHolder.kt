package com.stathis.runney.features.races.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.BR
import com.stathis.runney.abstraction.AbstractViewHolder
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.callbacks.RacesClickListener
import com.stathis.runney.databinding.HolderRacesVerticalItemBinding
import com.stathis.runney.models.RunningRace

class RacesScreenViewHolder(val binding: ViewDataBinding,val callback: ItemClickListener) : AbstractViewHolder(binding) {

    override fun present(data: LocalModel) {
        when (data) {
            is RunningRace -> {
                binding.setVariable(BR.runningRace,data)
                binding.setVariable(BR.callback,callback)
            }
        }
    }
}