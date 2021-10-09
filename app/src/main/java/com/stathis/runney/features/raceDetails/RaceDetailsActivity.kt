package com.stathis.runney.features.raceDetails

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityRaceDetailsBinding
import com.stathis.runney.models.RunningRace

class RaceDetailsActivity : AbstractActivity() {

    private lateinit var viewModel: RaceDetailsViewModel
    private lateinit var binding: ActivityRaceDetailsBinding
    private lateinit var race : RunningRace
    private var favorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRaceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(RaceDetailsViewModel::class.java)
    }

    override fun startOps() {
        race = intent.getSerializableExtra("RACE")  as RunningRace
        race.let {
            binding.race = it
            viewModel.checkIfFavorite(it)

            supportActionBar?.title = race.title
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

    }

    override fun stopOps() {}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.details_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }

            R.id.share_btn -> {
                shareNews()
                true
            }

            R.id.favorite_btn -> {
                when(favorite){
                    true -> viewModel.removeFromFavorites(race)
                    false -> viewModel.addToFavorites(race)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareNews() {
        val sharingIntent = Intent(Intent.ACTION_SEND).also{
            it.type = "text/plain"
            it.putExtra(Intent.EXTRA_TEXT, "You can learn more about ${race.title} by clicking here.")
        }
        startActivity(Intent.createChooser(sharingIntent, "Share using"))
    }
}