package com.stathis.runney.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load


class MyBindingAdapter {

    companion object{
        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun ImageView.loadImg(url: String) {
            this.load(url)
        }
    }
}

