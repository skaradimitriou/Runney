package com.stathis.runney.features.dashboard.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractFragment
import com.stathis.runney.callbacks.HomeScreenCallback
import com.stathis.runney.databinding.FragmentHomeBinding
import com.stathis.runney.features.dashboard.home.model.HomeItem
import androidx.recyclerview.widget.DefaultItemAnimator

import androidx.recyclerview.widget.StaggeredGridLayoutManager

import androidx.recyclerview.widget.OrientationHelper
import com.stathis.runney.features.results.ResultsActivity


class HomeFragment : AbstractFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun startOps() {
        binding.staggeredRecycler.adapter = viewModel.adapter

        viewModel.bindCallback(object : HomeScreenCallback {
            override fun onHomeItemTap(item: HomeItem) = goToResults(item.title)
        })

        viewModel.observe(this)

        viewModel.user.observe(this, Observer {
            binding.user = it
        })
    }

    override fun stopOps() {
        viewModel.release(this)
        viewModel.user.removeObservers(this)
    }

    fun goToResults(option : String){
        startActivity(Intent(requireContext(), ResultsActivity::class.java).also {
            it.putExtra("OPTION", option)
        })
    }
}