package com.stathis.runney.features.editProfile

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityEditProfileBinding

class EditProfileActivity : AbstractActivity() {

    private lateinit var viewModel : EditProfileViewModel
    private lateinit var binding : ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(EditProfileViewModel::class.java)
    }

    override fun startOps() {
        supportActionBar?.title = "Edit Profile"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun stopOps() {}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}