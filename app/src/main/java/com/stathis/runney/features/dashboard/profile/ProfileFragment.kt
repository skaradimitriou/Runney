package com.stathis.runney.features.dashboard.profile

import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractFragment


class ProfileFragment : AbstractFragment(R.layout.fragment_profile) {

    private lateinit var viewModel: ProfileViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun startOps() {
        //
    }

    override fun stopOps() {
        //
    }
}