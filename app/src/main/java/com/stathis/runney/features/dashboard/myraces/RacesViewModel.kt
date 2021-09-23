package com.stathis.runney.features.dashboard.myraces

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stathis.runney.callbacks.ItemClickListener
import com.stathis.runney.features.dashboard.myraces.adapter.RaceAdapter
import com.stathis.runney.features.dashboard.myraces.model.RunningRace

class RacesViewModel : ViewModel(), ItemClickListener {

    val adapter = RaceAdapter(this)
    val data = MutableLiveData<List<RunningRace>>()

    init {
        getData()
    }

    private fun getData() {
        val list = listOf(
            RunningRace("Test 1", "", ""),
            RunningRace("Test 2", "", ""),
            RunningRace("Test 3", "", ""),
            RunningRace("Test 4","",""),
            RunningRace("Test 5","","")
        )

        data.value = list
    }

    override fun onItemTap(view: View) {
        //
    }
}
