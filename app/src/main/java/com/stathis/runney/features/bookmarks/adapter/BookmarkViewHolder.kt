package com.stathis.runney.features.bookmarks.adapter

import androidx.databinding.ViewDataBinding
import com.stathis.runney.BR
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.features.results.adapter.BaseViewHolder
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace

class BookmarkViewHolder(val binding : ViewDataBinding) : BaseViewHolder(binding.root) {

    override fun present(data: LocalModel) {
        when(data){
            is News -> binding.setVariable(BR.news, data)
            is RunningRace -> binding.setVariable(BR.runningRace, data)
        }
    }
}