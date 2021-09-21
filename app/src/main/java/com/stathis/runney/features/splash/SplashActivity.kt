package com.stathis.runney.features.splash

import android.os.Bundle
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivitySplashBinding

class SplashActivity : AbstractActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
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