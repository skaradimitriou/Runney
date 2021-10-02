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


class HomeFragment : AbstractFragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

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
        /*
        FIXME: Stagerred grid with 3 categories (News, Articles, Running Races)

               1. User Greeting
               2. Something for desc
               3. List with actions
         */

        binding.staggeredRecycler.adapter = viewModel.adapter

        viewModel.bindCallback(object : HomeScreenCallback {
            override fun onHomeItemTap(item: HomeItem) {
                when(item.title){
                    getString(R.string.news) -> goToResults(item.title)
                    getString(R.string.article) -> goToResults(item.title)
                    getString(R.string.running_races) -> goToResults(item.title)
                    getString(R.string.something_else) -> goToResults(item.title)
                }
            }
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