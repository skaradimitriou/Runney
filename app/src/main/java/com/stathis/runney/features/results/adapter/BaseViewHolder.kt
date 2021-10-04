package com.stathis.runney.features.results.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stathis.runney.abstraction.LocalModel

abstract class BaseViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    abstract fun present(data : LocalModel)
}