package com.stathis.runney.features.dashboard.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.runney.abstraction.DiffUtilClass
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.HomeScreenCallback
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.databinding.HolderHomeOptionItemBinding

class HomeAdapter(val callback : ItemClickListener) : ListAdapter<LocalModel, HomeViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = HolderHomeOptionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HomeViewHolder(view,callback)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}