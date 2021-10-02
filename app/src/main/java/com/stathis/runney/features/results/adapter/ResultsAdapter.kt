package com.stathis.runney.features.results.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.R
import com.stathis.runney.abstraction.DiffUtilClass
import com.stathis.runney.abstraction.EmptyViewHolder
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.RacesClickListener
import com.stathis.runney.callbacks.ResultsCallback
import com.stathis.runney.databinding.HolderEmptyLayoutBinding
import com.stathis.runney.databinding.HolderRacesVerticalItemBinding
import com.stathis.runney.features.races.adapter.RacesScreenViewHolder
import com.stathis.runney.models.Article
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace

class ResultsAdapter(val callback : ResultsCallback) : ListAdapter<LocalModel,ResultsViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        val view = HolderRacesVerticalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ResultsViewHolder(view,callback)
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        holder.present(getItem(position))
    }
}