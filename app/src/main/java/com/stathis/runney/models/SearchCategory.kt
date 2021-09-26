package com.stathis.runney.models

import com.stathis.runney.abstraction.LocalModel

data class SearchCategory(val title : String) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
