package com.stathis.runney.features.dashboard.profile.model

import com.stathis.runney.abstraction.LocalModel

data class User(val name : String, val image : String) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
