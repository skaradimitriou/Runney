package com.stathis.runney.features.races.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.runney.abstraction.DiffUtilClass
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.RacesClickListener
import com.stathis.runney.databinding.HolderRacesVerticalItemBinding

class RacesScreenAdapter(val callback : RacesClickListener) : ListAdapter<LocalModel, RacesScreenViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RacesScreenViewHolder {
        val view = HolderRacesVerticalItemBinding.inflate(LayoutInflater.from(parent.context))
        return RacesScreenViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: RacesScreenViewHolder, position: Int) = holder.present(getItem(position))
}