package com.stathis.runney.models

import com.stathis.runney.abstraction.LocalModel

data class News(val title : String, val image : String) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
