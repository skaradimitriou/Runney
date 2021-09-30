package com.stathis.runney.features.dashboard.profile.model

import com.stathis.runney.abstraction.LocalModel

data class ProfileOption(val title : String, val image : Int) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
