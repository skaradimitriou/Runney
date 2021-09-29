package com.stathis.runney.features.races.adapter

import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.RacesClickListener
import com.stathis.runney.databinding.HolderRacesVerticalItemBinding
import com.stathis.runney.models.RunningRace

class RacesScreenViewHolder(val binding : HolderRacesVerticalItemBinding,val callback : RacesClickListener) : RecyclerView.ViewHolder(binding.root) {

    fun present(data : LocalModel){
        when(data){
            is RunningRace -> {
                binding.apply{
                    binding.runningRace = data

                    binding.parent.setOnClickListener{
                        callback.onRaceTap(binding.runningRace)
                    }
                }
            }
        }
    }
}