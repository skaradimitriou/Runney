package com.stathis.runney.features.races

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityRacesBinding

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
        //
    }

    override fun stopOps() {
        //
    }
}