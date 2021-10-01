package com.stathis.runney.features.dashboard.myraces

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.stathis.runney.callbacks.RacesClickListener
import com.stathis.runney.features.dashboard.myraces.adapter.RaceAdapter
import com.stathis.runney.models.RunningRace

class RacesViewModel : ViewModel(), RacesClickListener {

    val adapter = RaceAdapter(this)
    val data = MutableLiveData<List<RunningRace>>()
    private lateinit var callback : RacesClickListener

    fun getData(callback : RacesClickListener) {
        this.callback = callback
        val list = listOf(
            RunningRace("6ος Δρόμος των Αλκυόνων Night Run 29,7 & 6,6 χλμ", "http://www.runningnews.gr/lib_photos/gallery16/2016_02_20_100-50k/SPYR9748.jpg", "02 Οκτ 21","Athens, Greece",10),
            RunningRace("5ος Αγώνας Δρόμου Αλμυρού «Almyros City – Zerelia Lakes»", "http://www.runningnews.gr/lib_photos/gallery18/2018_10_07_almyros/ekkinisi_hmi.jpg", "03 Οκτ 21","Athens, Greece",10),
            RunningRace("Αγωνιστικός Δόλιχος Δρόμος - Ισσωρία Άρτεμις", "http://www.runningnews.gr/lib_photos/news21a/08/2021_08_30_issoria.jpg", "03 Οκτ 21","Athens, Greece",10),
            RunningRace("1o Flamingo Run","http://www.runningnews.gr/lib_photos/news21a/09/2021_09_02_Flamingo.jpg","03 Οκτ 21","Athens, Greece",10),
            RunningRace("Greece Race for the Cure®2021","http://www.runningnews.gr/lib_photos/news21a/03/2021_03_05_cure.jpg","03 Οκτ 21","Athens, Greece",10)
        )

        data.value = list
    }

    fun observe(owner : LifecycleOwner){
        data.observe(owner, Observer{
            adapter.submitList(it)
        })
    }

    fun release(owner : LifecycleOwner) = data.removeObservers(owner)

    override fun onRaceTap(race: RunningRace) = callback.onRaceTap(race)
}
