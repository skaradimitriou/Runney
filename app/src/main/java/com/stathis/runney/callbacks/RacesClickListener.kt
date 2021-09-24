package com.stathis.runney.callbacks

import com.stathis.runney.features.dashboard.myraces.model.RunningRace

interface RacesClickListener {

    fun onRaceTap(race : RunningRace)
}