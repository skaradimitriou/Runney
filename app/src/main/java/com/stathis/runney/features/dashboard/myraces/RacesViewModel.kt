package com.stathis.runney.features.dashboard.myraces

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stathis.runney.callbacks.RacesClickListener
import com.stathis.runney.features.dashboard.myraces.adapter.RaceAdapter
import com.stathis.runney.features.dashboard.myraces.model.RunningRace

class RacesViewModel : ViewModel(), RacesClickListener {

    val adapter = RaceAdapter(this)
    val data = MutableLiveData<List<RunningRace>>()
    private lateinit var callback : RacesClickListener

    fun getData(callback : RacesClickListener) {
        this.callback = callback
        val list = listOf(
            RunningRace("Test 1", "", ""),
            RunningRace("Test 2", "", ""),
            RunningRace("Test 3", "", ""),
            RunningRace("Test 4","",""),
            RunningRace("Test 5","","")
        )

        data.value = list
    }

    override fun onRaceTap(race: RunningRace) = callback.onRaceTap(race)
}
