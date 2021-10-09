package com.stathis.runney.features.articledetails

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityArticleDetailsBinding
import com.stathis.runney.models.Article

class ArticleDetailsActivity : AbstractActivity() {

    private lateinit var binding : ActivityArticleDetailsBinding
    private lateinit var viewModel : ArticleDetailsViewModel
    private lateinit var article : Article
    private var favorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(ArticleDetailsViewModel::class.java)
    }

    override fun startOps() {
        article = intent.getSerializableExtra("ARTICLE") as Article
        article?.let {
            //set to binding
            //viewModel.checkIfFavorite(it)

            supportActionBar?.title = it.title
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        viewModel.isFavorite.observe(this, Observer{
            favorite = when(it){
                true -> {
                    true
                }
                false -> false
            }
        })
    }

    override fun stopOps() {
        //
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
                    //true -> viewModel.removeFromFavorites(news)
                    //false -> viewModel.addToFavorites(news)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareNews() {
        val sharingIntent = Intent(Intent.ACTION_SEND).also{
            it.type = "text/plain"
            it.putExtra(Intent.EXTRA_TEXT, "You can learn more about ${article.title} by clicking here.")
        }
        startActivity(Intent.createChooser(sharingIntent, "Share using"))
    }
}