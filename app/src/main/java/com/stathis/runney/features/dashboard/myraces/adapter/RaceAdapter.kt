package com.stathis.runney.features.dashboard.myraces.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.runney.abstraction.DiffUtilClass
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.databinding.HolderRaceItemBinding

class RaceAdapter(private val callback : ItemClickListener) : ListAdapter<LocalModel, RaceViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceViewHolder {
        val view = HolderRaceItemBinding.inflate(LayoutInflater.from(parent.context))
        return RaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: RaceViewHolder, position: Int) = holder.present(getItem(position))
}