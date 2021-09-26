package com.stathis.runney.features.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractFragment
import com.stathis.runney.databinding.FragmentHomeBinding

class HomeFragment : AbstractFragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel : HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun startOps() {
        binding
    }

    override fun stopOps() {
        //
    }
}