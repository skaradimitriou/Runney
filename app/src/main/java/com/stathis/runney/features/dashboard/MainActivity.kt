package com.stathis.runney.features.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityMainBinding

class MainActivity : AbstractActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        supportActionBar?.hide()

        val navController = findNavController(R.id.nav_host_fragment)
        binding.bottomBar.onItemSelected = {
            when(it){
                0 -> navController.navigate(R.id.nav_home)
                1 -> navController.navigate(R.id.nav_search)
                2 -> navController.navigate(R.id.nav_profile)
                else -> Unit
            }
        }
    }

    override fun startOps() {}
    override fun stopOps() {}
}