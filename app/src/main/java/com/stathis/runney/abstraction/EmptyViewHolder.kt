package com.stathis.runney.abstraction

import androidx.databinding.ViewDataBinding

class EmptyViewHolder(val binding : ViewDataBinding) : AbstractViewHolder(binding) {

    override fun present(data: LocalModel) {}
}