package com.stathis.runney.features.results.adapter

import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ResultsCallback
import com.stathis.runney.databinding.HolderRacesVerticalItemBinding
import com.stathis.runney.models.RunningRace

class ResultsViewHolder(val binding : HolderRacesVerticalItemBinding, val callback : ResultsCallback): BaseViewHolder(binding.root) {

    override fun present(data: LocalModel) {
        when (data) {
            is RunningRace -> {
                binding.apply {
                    binding.runningRace = data
                    binding.parentScreen.setOnClickListener { callback.onRaceTap(data) }
                }
            }
        }
    }
}