package com.stathis.runney.features.dashboard.home.model

import com.stathis.runney.abstraction.LocalModel

data class HomeItem(val title : String, val image : Int) : LocalModel {
    override fun equalsContent(data: LocalModel): Boolean = false
}
