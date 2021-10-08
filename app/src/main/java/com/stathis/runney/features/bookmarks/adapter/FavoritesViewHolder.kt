package com.stathis.runney.features.bookmarks.adapter

import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.databinding.HolderRacesVerticalItemBinding
import com.stathis.runney.features.results.adapter.BaseViewHolder
import com.stathis.runney.models.RunningRace

class FavoritesViewHolder(val binding : HolderRacesVerticalItemBinding) : BaseViewHolder(binding.root) {

    override fun present(data: LocalModel) {
        when(data){
            is RunningRace -> binding.runningRace = data
        }
    }
}