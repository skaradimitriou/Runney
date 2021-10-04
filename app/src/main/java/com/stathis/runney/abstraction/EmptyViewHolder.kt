package com.stathis.runney.abstraction

import com.stathis.runney.databinding.HolderEmptyLayoutBinding
import com.stathis.runney.features.results.adapter.BaseViewHolder

class EmptyViewHolder(val binding : HolderEmptyLayoutBinding) : BaseViewHolder(binding.root) {
    override fun present(data: LocalModel) {
        //
    }
}