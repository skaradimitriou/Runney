package com.stathis.runney.features.newsDetails

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityNewsBinding
import com.stathis.runney.models.News

class NewsActivity : AbstractActivity() {

    private lateinit var viewModel : NewsViewModel
    private lateinit var binding : ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
    }

    override fun startOps() {
        val model = intent.getSerializableExtra("NEWS") as News
        model?.let{
            binding.news = it
            supportActionBar?.title = it.title
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun stopOps() {
        //
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        //handle the other items when clicked
    }
}