package com.stathis.runney.features.results

import android.app.Application
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractViewModel
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ResultsCallback
import com.stathis.runney.features.results.adapter.ResultsAdapter
import com.stathis.runney.models.Article
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace
import kotlinx.coroutines.*
import java.util.*

class ResultsViewModel(app: Application) : AbstractViewModel(app), ResultsCallback {

    private val firestore = FirebaseFirestore.getInstance()
    val adapter = ResultsAdapter(this)
    val results = MutableLiveData<List<LocalModel>>()
    val isLoading = MutableLiveData<Boolean>()
    private lateinit var callback: ResultsCallback

    fun bindCallback(callback: ResultsCallback) {
        this.callback = callback
    }

    fun getData(option: String) {
        isLoading.value = true

        viewModelScope.launch {
            delay(1000)
            when (option) {
                getString(R.string.news) -> getNews()
                getString(R.string.running_races) -> getRaces()
                getString(R.string.article) -> getArticles()
                else -> Unit
            }
        }
    }

    private fun getNews() {
        val list = listOf(
            News(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            News(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            News(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            News(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            News(getString(R.string.dummy_title), getString(R.string.dummy_img)),
        )

        results.value = list
    }

    private fun getRaces() {
        firestore.collection("races").get().addOnSuccessListener { docs ->
            val racesList = arrayListOf<RunningRace>()
            for (document in docs) {
                val race = document.toObject(RunningRace::class.java)
                racesList.add(race)
            }

            /*
                This should be sorted according to date
             */

            results.value = racesList
        }.addOnFailureListener {
            Log.d("TAG", "Error getting documents: ", it)
            results.value = null
        }
    }

    private fun getArticles() {
        val list = listOf(
            Article(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            Article(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            Article(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            Article(getString(R.string.dummy_title), getString(R.string.dummy_img)),
            Article(getString(R.string.dummy_title), getString(R.string.dummy_img)),
        )

        results.value = list
    }

    fun observe(owner: LifecycleOwner) {
        results.observe(owner, Observer {
            adapter.submitList(it)
            isLoading.value = false
        })
    }

    fun release(owner: LifecycleOwner) {
        results.removeObservers(owner)
    }

    override fun onNewsTap(news: News) = callback.onNewsTap(news)
    override fun onRaceTap(race: RunningRace) = callback.onRaceTap(race)
    override fun onArticleTap(article: Article) = callback.onArticleTap(article)
}
