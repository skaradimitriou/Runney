package com.stathis.runney.callbacks

import com.stathis.runney.models.RunningRace

interface RacesClickListener {
    fun onRaceTap(race : RunningRace)
}