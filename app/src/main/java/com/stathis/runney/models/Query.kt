package com.stathis.runney.models

import com.stathis.runney.abstraction.LocalModel

data class Query(val query : String) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
