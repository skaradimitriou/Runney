package com.stathis.runney.features.dashboard.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractFragment
import com.stathis.runney.callbacks.ProfileOptionsCallback
import com.stathis.runney.databinding.FragmentProfileBinding
import com.stathis.runney.features.dashboard.profile.model.ProfileOption


class ProfileFragment : AbstractFragment() {

    private lateinit var binding : FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun startOps() {
        binding.profileOptionsRecycler.adapter = viewModel.adapter

        binding.editProfile.setOnClickListener {
            //redirect to edit profile screen
        }

        viewModel.bindCallback(object : ProfileOptionsCallback{
            override fun onOptionTap(option: ProfileOption) {
                //
            }
        })

        viewModel.user.observe(this, Observer{
            binding.user = it
        })

        /*
        FIXME: Implement dark mode functionality in profile
         */
    }

    override fun stopOps() = viewModel.user.removeObservers(this)
}