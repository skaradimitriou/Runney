package com.stathis.runney.util

import android.widget.ImageView

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class Util {

    fun loadImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

    @BindingAdapter("android:imageUrl")
    fun loadImg(img: ImageView, url: String?) {
        loadImage(img, url)
    }
}