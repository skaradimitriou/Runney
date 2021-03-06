package com.stathis.runney.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load


class MyBindingAdapters {

    companion object{
        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun ImageView.loadImg(url: String) {
            this.load(url)
        }

        @BindingAdapter("loadMyImg")
        @JvmStatic
        fun loadMyImg(img : ImageView, url : String){
            img.load(url)
        }

        @BindingAdapter("setImgResource")
        @JvmStatic
        fun setImage(img : ImageView, imgFile : Int){
            img.setImageResource(imgFile)
        }

        @BindingAdapter("setIntTextToEuros")
        @JvmStatic
        fun TextView.setText(value : Int){
            this.text = "$value €"
        }
    }
}

