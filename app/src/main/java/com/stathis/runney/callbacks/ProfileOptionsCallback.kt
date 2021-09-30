package com.stathis.runney.callbacks

import com.stathis.runney.features.dashboard.profile.model.ProfileOption

interface ProfileOptionsCallback {
    fun onOptionTap(option : ProfileOption)
}