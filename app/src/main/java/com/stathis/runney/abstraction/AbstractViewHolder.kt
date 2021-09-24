package com.stathis.runney.abstraction

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.callbacks.ItemClickListener

abstract class AbstractViewHolder(itemView : View, callback : ItemClickListener) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView?.let {
            callback?.onItemTap(it)
        }
    }

    fun bindData(data: LocalModel) {
        itemView.tag = data
        present(data)
    }

    abstract fun present(data: LocalModel)
}