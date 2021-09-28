package com.stathis.runney.features.newsDetails

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityNewsBinding

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
        //
    }

    override fun stopOps() {
        //
    }
}