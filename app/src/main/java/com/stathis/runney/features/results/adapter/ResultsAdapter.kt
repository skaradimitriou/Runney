package com.stathis.runney.features.results.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.runney.R
import com.stathis.runney.abstraction.DiffUtilClass
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.databinding.*
import com.stathis.runney.models.Article
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace

class ResultsAdapter(val callback : ItemClickListener) : ListAdapter<LocalModel,ArticlesViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            R.layout.holder_article_item -> {
                val view = HolderArticleItemBinding.inflate(inflater,parent,false)
                ArticlesViewHolder(view,callback)
            }

            else -> {
                val view = HolderArticleItemBinding.inflate(inflater,parent,false)
                ArticlesViewHolder(view,callback)
            }
        }
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)){
        is RunningRace -> R.layout.holder_races_vertical_item
        is News -> R.layout.holder_news_vertical_item
        is Article -> R.layout.holder_article_item
        else -> R.layout.holder_empty_layout
    }
}