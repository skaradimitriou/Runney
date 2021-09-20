package com.stathis.runney.features.dashboard

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityMainBinding

class MainActivity : AbstractActivity(R.layout.activity_main) {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    override fun init() {
        val navController = findNavController(R.id.nav_host_fragment)
        binding.bottomNavigationMenu.setupWithNavController(navController)
    }

    override fun startOps() {}
    override fun stopOps() {}
}