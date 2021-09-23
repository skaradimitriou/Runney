package com.stathis.runney.features.dashboard.myraces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractFragment
import com.stathis.runney.databinding.FragmentRacesBinding

class RacesFragment : AbstractFragment() {

    private lateinit var binding: FragmentRacesBinding
    private lateinit var viewModel: RacesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRacesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(RacesViewModel::class.java)
    }

    override fun startOps() {
        binding.racesRecycler.adapter = viewModel.adapter

        viewModel.data.observe(this, Observer{
            viewModel.adapter.submitList(it)
        })
    }

    override fun stopOps() {
        viewModel.data.removeObservers(this)
    }
}