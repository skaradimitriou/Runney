package com.stathis.runney.models

import com.stathis.runney.abstraction.LocalModel

data class Article(val title : String, val image : String) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}