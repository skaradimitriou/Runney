package com.stathis.runney.callbacks

import com.stathis.runney.features.dashboard.home.model.HomeItem

interface HomeScreenCallback {
    fun onHomeItemTap(item : HomeItem)
}