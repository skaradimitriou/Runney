package com.stathis.runney.features.bookmarks.adapter

import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.databinding.HolderNewsVerticalItemBinding
import com.stathis.runney.features.results.adapter.BaseViewHolder
import com.stathis.runney.models.Article
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace

class BookmarkViewHolder(val binding : HolderNewsVerticalItemBinding) : BaseViewHolder(binding.root) {

    override fun present(data: LocalModel) {
        when(data){
            is News -> binding.news = data
        }
    }
}