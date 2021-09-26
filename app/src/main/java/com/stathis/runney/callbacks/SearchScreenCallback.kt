package com.stathis.runney.callbacks

import com.stathis.runney.models.SearchCategory

interface SearchScreenCallback {

    fun onCategoryTap(category : SearchCategory)
}