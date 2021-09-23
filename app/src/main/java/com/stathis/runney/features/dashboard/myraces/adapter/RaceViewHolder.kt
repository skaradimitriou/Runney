package com.stathis.runney.features.dashboard.myraces.adapter

import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.databinding.HolderRaceItemBinding
import com.stathis.runney.features.dashboard.myraces.model.RunningRace

class RaceViewHolder(val binding : HolderRaceItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun present(data: LocalModel) {
        when(data){
            is RunningRace -> binding.runningRace = data
        }
    }
}