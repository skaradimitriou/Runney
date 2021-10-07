package com.stathis.runney.features.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivitySplashBinding
import com.stathis.runney.features.login.LoginActivity

class SplashActivity : AbstractActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        Handler(Looper.getMainLooper()).postDelayed({
            val mainIntent = Intent(this, LoginActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 3000)
    }

    override fun startOps() {}

    override fun stopOps() {}
}