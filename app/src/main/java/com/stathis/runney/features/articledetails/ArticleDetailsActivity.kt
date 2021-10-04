package com.stathis.runney.features.articledetails

import android.os.Bundle
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityArticleDetailsBinding

class ArticleDetailsActivity : AbstractActivity() {

    private lateinit var binding : ActivityArticleDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        //
    }

    override fun startOps() {
        //
    }

    override fun stopOps() {
        //
    }
}