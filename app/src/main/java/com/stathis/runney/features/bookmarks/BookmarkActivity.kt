package com.stathis.runney.features.bookmarks

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
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
        //
    }

    override fun stopOps() {
        //
    }
}