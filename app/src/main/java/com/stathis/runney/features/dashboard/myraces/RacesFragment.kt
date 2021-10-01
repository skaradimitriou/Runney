package com.stathis.runney.features.dashboard.myraces

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.stathis.runney.abstraction.AbstractFragment
import com.stathis.runney.callbacks.RacesClickListener
import com.stathis.runney.databinding.FragmentRacesBinding
import com.stathis.runney.models.RunningRace
import com.stathis.runney.features.details.DetailActivity
import com.stathis.runney.features.raceDetails.RaceDetailsActivity

class RacesFragment : AbstractFragment() {

    private lateinit var binding: FragmentRacesBinding
    private lateinit var viewModel: RacesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRacesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(RacesViewModel::class.java)
    }

    override fun startOps() {
        viewModel.getData(object : RacesClickListener {
            override fun onRaceTap(race: RunningRace) = openRaceDetails(race)
        })

        binding.racesRecycler.adapter = viewModel.adapter

        viewModel.observe(this)
    }

    override fun stopOps() = viewModel.release(this)


    private fun openRaceDetails(race: RunningRace) {
        val model = Gson().toJson(race)
        startActivity(Intent(requireContext(),RaceDetailsActivity::class.java).also {
            it.putExtra("RACE",model)
        })
    }
}