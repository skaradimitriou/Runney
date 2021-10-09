package com.stathis.runney.models

import com.stathis.runney.abstraction.LocalModel

data class RunningRace(

    val title : String,
    val image : String,
    val date : String,
    val location : String,
    val cost : Int

) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
    constructor() : this ("","","","",0)
}
