package com.stathis.runney.abstraction

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractBindingViewHolder(itemView : ViewDataBinding) : RecyclerView.ViewHolder(itemView.root){

    fun bindData(data : LocalModel){
        itemView.tag = data
        present(data)
    }

    abstract fun present(data : LocalModel)
}