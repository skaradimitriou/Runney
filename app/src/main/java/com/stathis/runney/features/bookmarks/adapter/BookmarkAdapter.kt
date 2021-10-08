package com.stathis.runney.features.bookmarks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.runney.R
import com.stathis.runney.abstraction.DiffUtilClass
import com.stathis.runney.abstraction.EmptyViewHolder
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.databinding.HolderArticleItemBinding
import com.stathis.runney.databinding.HolderEmptyLayoutBinding
import com.stathis.runney.databinding.HolderNewsVerticalItemBinding
import com.stathis.runney.databinding.HolderRacesVerticalItemBinding
import com.stathis.runney.features.results.adapter.BaseViewHolder
import com.stathis.runney.models.Article
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace

class BookmarkAdapter() : ListAdapter<LocalModel,BaseViewHolder>(DiffUtilClass<LocalModel>()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder = when(viewType){
        R.layout.holder_races_vertical_item -> {
            val view = HolderRacesVerticalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            FavoritesViewHolder(view)
        }

        R.layout.holder_news_vertical_item -> {
            val view = HolderNewsVerticalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            BookmarkViewHolder(view)
        }

        R.layout.holder_article_item -> {
            val view = HolderArticleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            ArticleViewHolder(view)
        }
        else -> {
            val view = HolderEmptyLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            EmptyViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.present(getItem(position))
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)){
        is RunningRace -> R.layout.holder_races_vertical_item
        is News -> R.layout.holder_news_vertical_item
        is Article -> R.layout.holder_article_item
        else -> R.layout.holder_empty_layout
    }
}