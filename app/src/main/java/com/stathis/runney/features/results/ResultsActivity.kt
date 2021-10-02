package com.stathis.runney.features.results

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityResultsBinding

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
        }
    }

    override fun stopOps() {
        //
    }
}