package com.stathis.runney.models

import com.stathis.runney.abstraction.LocalModel

data class RunningRace(

    val title : String,
    val image : String,
    val date : String,

) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}
