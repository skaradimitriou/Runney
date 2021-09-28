package com.stathis.runney.features.raceDetails

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityRaceDetailsBinding

class RaceDetailsActivity : AbstractActivity() {

    private lateinit var viewModel: RaceDetailsViewModel
    private lateinit var binding: ActivityRaceDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRaceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(RaceDetailsViewModel::class.java)
    }

    override fun startOps() {
        //
    }

    override fun stopOps() {
        //
    }
}