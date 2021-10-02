package com.stathis.runney.features.results

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.callbacks.ResultsCallback
import com.stathis.runney.databinding.ActivityResultsBinding
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
            override fun onNewsTap(news: News) = openNews()
            override fun onRaceTap(race: RunningRace) = openRace()
            override fun onArticleTap(article: Article) = openArticle()
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

    private fun openNews(){}

    private fun openRace(){}

    private fun openArticle(){}
}