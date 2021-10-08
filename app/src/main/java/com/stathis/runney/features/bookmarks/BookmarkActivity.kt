package com.stathis.runney.features.bookmarks

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityBookmarkBinding

class BookmarkActivity : AbstractActivity() {

    private lateinit var viewModel: BookmarkViewModel
    private lateinit var binding: ActivityBookmarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(BookmarkViewModel::class.java)
    }

    override fun startOps() {
        val title = intent.getStringExtra(getString(R.string.title_uppercase)) ?: ""
        title.let {
            supportActionBar?.title = it
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            viewModel.getResults(it)
        }

        binding.bookmarkRecycler.adapter = viewModel.adapter

        viewModel.observe(this)
    }

    override fun stopOps() = viewModel.release(this)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}