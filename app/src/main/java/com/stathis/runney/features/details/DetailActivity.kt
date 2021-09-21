package com.stathis.runney.features.details

import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractActivity

class DetailActivity : AbstractActivity() {

    private lateinit var viewModel: DetailsViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    override fun startOps() {
        //
    }

    override fun stopOps() {
        //
    }
}