package com.stathis.runney.callbacks

import com.stathis.runney.models.Query

interface SearchScreenCallback {
    fun onQueryTap(query: Query)
}