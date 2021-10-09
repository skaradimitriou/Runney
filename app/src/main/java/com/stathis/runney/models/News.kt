package com.stathis.runney.models

import com.stathis.runney.abstraction.LocalModel
import java.io.Serializable

data class News(val title : String, val image : String) : Serializable, LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
