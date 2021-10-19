package com.stathis.runney.features.results.adapter

import androidx.databinding.ViewDataBinding
import com.stathis.runney.BR
import com.stathis.runney.abstraction.AbstractBindingViewHolder
import com.stathis.runney.abstraction.AbstractViewHolder
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.callbacks.ResultsCallback
import com.stathis.runney.databinding.HolderArticleItemBinding
import com.stathis.runney.models.Article

class ArticlesViewHolder(val binding: ViewDataBinding, val callback: ItemClickListener) :
    AbstractBindingViewHolder(binding) {

    override fun present(data: LocalModel) {
        when (data) {
            is Article -> {
                binding.setVariable(BR.article, data)
                binding.setVariable(BR.callback, callback)
            }
        }
    }
}