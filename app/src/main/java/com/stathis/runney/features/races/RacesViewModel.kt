package com.stathis.runney.features.races

import androidx.lifecycle.ViewModel
import com.stathis.runney.callbacks.RacesClickListener
import com.stathis.runney.features.races.adapter.RacesScreenAdapter
import com.stathis.runney.models.RunningRace

class RacesViewModel : ViewModel(), RacesClickListener {

    val adapter = RacesScreenAdapter(this)
    private lateinit var callback : RacesClickListener

    fun getData(callback : RacesClickListener){
        this.callback = callback

        adapter.submitList(listOf(
            RunningRace("Test 1", "", "","",1),
            RunningRace("Test 2", "", "","",1),
            RunningRace("Test 3", "", "","",1),
            RunningRace("Test 4","","","",1),
            RunningRace("Test 5","","","",1)
        ))
    }

    override fun onRaceTap(race: RunningRace) {
        callback.onRaceTap(race)
    }
}