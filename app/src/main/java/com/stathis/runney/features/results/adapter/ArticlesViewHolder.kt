package com.stathis.runney.features.results.adapter

import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ResultsCallback
import com.stathis.runney.databinding.HolderArticleItemBinding
import com.stathis.runney.models.Article

class ArticlesViewHolder(val binding : HolderArticleItemBinding, val callback : ResultsCallback): BaseViewHolder(binding.root) {

    override fun present(data: LocalModel) {
        when (data) {
            is Article -> {
                binding.apply {
                    binding.article = data
                    binding.parent.setOnClickListener { callback.onArticleTap(data)}
                }
            }
        }
    }
}