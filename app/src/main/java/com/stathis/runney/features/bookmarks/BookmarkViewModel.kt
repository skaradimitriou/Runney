package com.stathis.runney.features.bookmarks

import android.app.Application
import androidx.lifecycle.*
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractViewModel
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.features.bookmarks.adapter.BookmarkAdapter
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BookmarkViewModel(app: Application) : AbstractViewModel(app) {

    val adapter = BookmarkAdapter()
    val data = MutableLiveData<List<LocalModel>>()

    fun getResults(input: String) {
        viewModelScope.launch {
            delay(500)
            when (input) {
                getString(R.string.favorites) -> getFavorites()
                getString(R.string.bookmarks) -> getBookmarks()
            }
        }
    }

    private fun getFavorites() {
        val list = listOf(
            RunningRace(
                "6ος Δρόμος των Αλκυόνων Night Run 29,7 & 6,6 χλμ",
                "http://www.runningnews.gr/lib_photos/gallery16/2016_02_20_100-50k/SPYR9748.jpg",
                "02 Οκτ 21",
                "Athens, Greece",
                10
            ),
            RunningRace(
                "5ος Αγώνας Δρόμου Αλμυρού «Almyros City – Zerelia Lakes»",
                "http://www.runningnews.gr/lib_photos/gallery18/2018_10_07_almyros/ekkinisi_hmi.jpg",
                "03 Οκτ 21",
                "Athens, Greece",
                10
            ),
            RunningRace(
                "Αγωνιστικός Δόλιχος Δρόμος - Ισσωρία Άρτεμις",
                "http://www.runningnews.gr/lib_photos/news21a/08/2021_08_30_issoria.jpg",
                "03 Οκτ 21",
                "Athens, Greece",
                10
            ),
            RunningRace(
                "1o Flamingo Run",
                "http://www.runningnews.gr/lib_photos/news21a/09/2021_09_02_Flamingo.jpg",
                "03 Οκτ 21",
                "Athens, Greece",
                10
            ),
            RunningRace(
                "Greece Race for the Cure®2021",
                "http://www.runningnews.gr/lib_photos/news21a/03/2021_03_05_cure.jpg",
                "03 Οκτ 21",
                "Athens, Greece",
                10
            )
        )

        data.value = list
    }

    private fun getBookmarks() {
        //get data from firebase

        val list = listOf(
            News(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            News(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            News(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            News(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            News(getString(R.string.dummy_title), getString(R.string.dummy_img)),
        )

        data.value = list
    }

    fun observe(owner: LifecycleOwner) {
        data.observe(owner, Observer {
            adapter.submitList(it)
        })
    }

    fun release(owner: LifecycleOwner) {
        data.removeObservers(owner)
    }
}