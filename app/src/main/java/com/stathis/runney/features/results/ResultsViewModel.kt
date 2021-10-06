package com.stathis.runney.features.results

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractViewModel
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.ResultsCallback
import com.stathis.runney.features.results.adapter.ResultsAdapter
import com.stathis.runney.models.Article
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ResultsViewModel(app: Application) : AbstractViewModel(app), ResultsCallback {

    val adapter = ResultsAdapter(this)
    val data = MutableLiveData<List<LocalModel>>()
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
            News("Lorem ipsum sit dolor amet"),
            News("Lorem ipsum sit dolor amet"),
            News("Lorem ipsum sit dolor amet"),
            News("Lorem ipsum sit dolor amet"),
            News("Lorem ipsum sit dolor amet"),
        )

        data.value = list
    }

    private fun getRaces() {
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

    private fun getArticles() {
        val list = listOf(
            Article(
                "Lorem ipsum sit dolor amet",
                "http://www.runningnews.gr/lib_photos/news21a/03/2021_03_05_cure.jpg"
            ),
            Article(
                "Lorem ipsum sit dolor amet",
                "http://www.runningnews.gr/lib_photos/news21a/03/2021_03_05_cure.jpg"
            ),
            Article(
                "Lorem ipsum sit dolor amet",
                "http://www.runningnews.gr/lib_photos/news21a/03/2021_03_05_cure.jpg"
            ),
            Article(
                "Lorem ipsum sit dolor amet",
                "http://www.runningnews.gr/lib_photos/news21a/03/2021_03_05_cure.jpg"
            ),
            Article(
                "Lorem ipsum sit dolor amet",
                "http://www.runningnews.gr/lib_photos/news21a/03/2021_03_05_cure.jpg"
            ),
        )

        data.value = list
    }

    fun observe(owner: LifecycleOwner) {
        data.observe(owner, Observer {
            adapter.submitList(it)
            isLoading.value = false
        })
    }

    fun release(owner: LifecycleOwner) {
        data.removeObservers(owner)
    }

    override fun onNewsTap(news: News) = callback.onNewsTap(news)
    override fun onRaceTap(race: RunningRace) = callback.onRaceTap(race)
    override fun onArticleTap(article: Article) = callback.onArticleTap(article)
}
