package com.stathis.runney.features.races

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.callbacks.RacesClickListener
import com.stathis.runney.databinding.ActivityRacesBinding
import com.stathis.runney.models.RunningRace

class RacesActivity : AbstractActivity() {

    private lateinit var viewModel: RacesViewModel
    private lateinit var binding: ActivityRacesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRacesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(RacesViewModel::class.java)
    }

    override fun startOps() {
        binding.racesScreenRecycler.adapter = viewModel.adapter

        viewModel.getData(object : RacesClickListener {
            override fun onRaceTap(race: RunningRace) {
                //do magic
            }
        })
    }

    override fun stopOps() {
        //
    }
}