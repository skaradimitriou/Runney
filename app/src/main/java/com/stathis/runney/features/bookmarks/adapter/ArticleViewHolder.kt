package com.stathis.runney.features.bookmarks.adapter

import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.databinding.HolderArticleItemBinding
import com.stathis.runney.features.results.adapter.BaseViewHolder
import com.stathis.runney.models.Article
import com.stathis.runney.models.News

class ArticleViewHolder(val binding : HolderArticleItemBinding) : BaseViewHolder(binding.root) {

    override fun present(data: LocalModel) {
        when(data){
            is Article -> binding.article = data
        }
    }
}