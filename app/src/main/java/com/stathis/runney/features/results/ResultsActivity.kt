package com.stathis.runney.features.results

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.callbacks.ResultsCallback
import com.stathis.runney.databinding.ActivityResultsBinding
import com.stathis.runney.features.articledetails.ArticleDetailsActivity
import com.stathis.runney.features.newsDetails.NewsActivity
import com.stathis.runney.features.raceDetails.RaceDetailsActivity
import com.stathis.runney.models.Article
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace

class ResultsActivity : AbstractActivity() {

    private lateinit var binding : ActivityResultsBinding
    private lateinit var viewModel : ResultsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(ResultsViewModel::class.java)
    }

    override fun startOps() {
        val option = intent.getStringExtra("OPTION")
        option?.let{
            supportActionBar?.title = it
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            viewModel.getData(it)
        }

        binding.resultsRecycler.adapter = viewModel.adapter

        viewModel.bindCallback(object : ResultsCallback{
            override fun onNewsTap(news: News) = openNews(news)
            override fun onRaceTap(race: RunningRace) = openRace(race)
            override fun onArticleTap(article: Article) = openArticle(article)
        })

        viewModel.observe(this)

        viewModel.isLoading.observe(this, Observer{
            when(it){
                true -> binding.resultsLoadingBar.visibility = View.VISIBLE
                false -> binding.resultsLoadingBar.visibility = View.GONE
            }
        })
    }

    override fun stopOps() {
        viewModel.release(this)
        viewModel.isLoading.removeObservers(this)
    }

    private fun openNews(news: News){
        val json = Gson().toJson(news)
        startActivity(Intent(this,NewsActivity::class.java).also{
            it.putExtra("NEWS",json)
        })
    }

    private fun openRace(race : RunningRace){
        val json = Gson().toJson(race)
        startActivity(Intent(this,RaceDetailsActivity::class.java).also{
            it.putExtra("RACE",json)
        })
    }

    private fun openArticle(article : Article){
        val json = Gson().toJson(article)
        startActivity(Intent(this, ArticleDetailsActivity::class.java).also{
            it.putExtra("ARTICLE",json)
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}