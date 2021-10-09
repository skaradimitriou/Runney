package com.stathis.runney.features.newsDetails

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityNewsBinding
import com.stathis.runney.models.News
import android.content.Intent
import androidx.lifecycle.Observer

class NewsActivity : AbstractActivity() {

    private lateinit var viewModel : NewsViewModel
    private lateinit var binding : ActivityNewsBinding
    private lateinit var news : News
    private var favorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
    }

    override fun startOps() {
        news = intent.getSerializableExtra("NEWS") as News
        news?.let{
            binding.news = it

            viewModel.checkIfFavorite(it)

            supportActionBar?.title = it.title
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        viewModel.isFavorite.observe(this,Observer{
            favorite = when(it){
                true -> {
                    true
                }
                false -> false
            }
        })
    }

    override fun stopOps() {
        viewModel.isFavorite.removeObservers(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.details_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }

            R.id.share_btn -> {
                shareNews()
                true
            }

            R.id.favorite_btn -> {
                when(favorite){
                    true -> viewModel.removeFromFavorites(news)
                    false -> viewModel.addToFavorites(news)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareNews() {
        val sharingIntent = Intent(Intent.ACTION_SEND).also{
            it.type = "text/plain"
            it.putExtra(Intent.EXTRA_TEXT, "You can learn more about ${news.title} by clicking here.")
        }
        startActivity(Intent.createChooser(sharingIntent, "Share using"))
    }
}