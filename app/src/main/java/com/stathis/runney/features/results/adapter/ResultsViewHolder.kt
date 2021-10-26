package com.stathis.runney.features.results.adapter

import androidx.databinding.ViewDataBinding
import com.stathis.runney.BR
import com.stathis.runney.abstraction.AbstractViewHolder
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ResultsCallback
import com.stathis.runney.databinding.HolderRacesVerticalItemBinding
import com.stathis.runney.models.RunningRace

class ResultsViewHolder(val binding : ViewDataBinding, val callback : ResultsCallback): AbstractViewHolder(binding) {

    override fun present(data: LocalModel) {
        when (data) {
            is RunningRace -> {
                binding.setVariable(BR.runningRace,data)
                binding.setVariable(BR.callback,callback)
            }
        }
    }
}