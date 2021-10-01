package com.stathis.runney.features.raceDetails

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityRaceDetailsBinding
import com.stathis.runney.models.RunningRace

class RaceDetailsActivity : AbstractActivity() {

    private lateinit var viewModel: RaceDetailsViewModel
    private lateinit var binding: ActivityRaceDetailsBinding
    private lateinit var race : RunningRace

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRaceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(RaceDetailsViewModel::class.java)
    }

    override fun startOps() {
        /*
        FIXME: Add Motion Layout
         */

        val model = intent.getStringExtra("RACE") ?: ""

        model.let {
            race = Gson().fromJson(model, RunningRace::class.java)
            Log.d("",race.toString())
            binding.race = race
            supportActionBar?.title = race.title
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun stopOps() {}
}