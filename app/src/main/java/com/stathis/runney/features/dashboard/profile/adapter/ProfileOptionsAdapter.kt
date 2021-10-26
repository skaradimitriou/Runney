package com.stathis.runney.features.dashboard.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.runney.abstraction.DiffUtilClass
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.callbacks.ProfileOptionsCallback
import com.stathis.runney.databinding.HolderProfileOptionItemBinding

class ProfileOptionsAdapter(val callback : ItemClickListener) : ListAdapter<LocalModel, ProfileOptionsViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileOptionsViewHolder {
        val view = HolderProfileOptionItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProfileOptionsViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: ProfileOptionsViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}