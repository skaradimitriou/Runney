package com.stathis.runney.features.results.adapter

import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ResultsCallback
import com.stathis.runney.databinding.HolderNewsVerticalItemBinding
import com.stathis.runney.models.News

class NewsViewHolder(val binding : HolderNewsVerticalItemBinding, val callback : ResultsCallback): BaseViewHolder(binding.root) {

    override fun present(data: LocalModel) {
        when (data) {
            is News -> {
                binding.apply {
                    binding.news = data
                    binding.parent.setOnClickListener { callback.onNewsTap(data)}
                }
            }
        }
    }
}