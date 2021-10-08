package com.stathis.runney.features.dashboard.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractFragment
import com.stathis.runney.callbacks.ProfileOptionsCallback
import com.stathis.runney.databinding.FragmentProfileBinding
import com.stathis.runney.features.bookmarks.BookmarkActivity
import com.stathis.runney.features.dashboard.profile.model.ProfileOption
import com.stathis.runney.features.editProfile.EditProfileActivity


class ProfileFragment : AbstractFragment() {

    private lateinit var binding : FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun startOps() {
        binding.profileOptionsRecycler.adapter = viewModel.adapter

        binding.editProfile.setOnClickListener { goToEditProfile() }

        binding.darkModeLayout.darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            when(isChecked){
                true -> darkModeEnabled(true)
                false -> darkModeEnabled(false)
            }
        }
        viewModel.bindCallback(object : ProfileOptionsCallback{
            override fun onOptionTap(option: ProfileOption) {
                when(option.title){
                    getString(R.string.favorites) -> goToFavorites()
                    getString(R.string.bookmarks) -> goToBookmarks()
                    getString(R.string.settings) -> goToSettings()
                }
            }
        })

        viewModel.user.observe(this, Observer{
            binding.user = it
        })
    }

    private fun darkModeEnabled(isChecked: Boolean) {
//        when(isChecked){
//            true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        }
    }

    private fun goToEditProfile() {
        startActivity(Intent(requireContext(), EditProfileActivity::class.java))
    }

    private fun goToBookmarks() {
        startActivity(Intent(requireContext(), BookmarkActivity::class.java).also {
            it.putExtra(getString(R.string.title_uppercase),getString(R.string.bookmarks))
        })
    }

    private fun goToSettings() {
        //define screen
    }

    private fun goToFavorites() {
        startActivity(Intent(requireContext(), BookmarkActivity::class.java).also {
            it.putExtra(getString(R.string.title_uppercase),getString(R.string.favorites))
        })
    }

    override fun stopOps() = viewModel.user.removeObservers(this)
}