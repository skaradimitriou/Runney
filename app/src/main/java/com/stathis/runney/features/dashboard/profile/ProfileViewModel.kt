package com.stathis.runney.features.dashboard.profile

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractViewModel
import com.stathis.runney.callbacks.ProfileOptionsCallback
import com.stathis.runney.features.dashboard.profile.adapter.ProfileOptionsAdapter
import com.stathis.runney.features.dashboard.profile.model.ProfileOption
import com.stathis.runney.features.dashboard.profile.model.User

class ProfileViewModel(app: Application) : AbstractViewModel(app), ProfileOptionsCallback {

    val adapter = ProfileOptionsAdapter(this)
    val user = MutableLiveData<User>()
    private lateinit var callback: ProfileOptionsCallback

    init {
        getData()
        getUser()
    }

    private fun getUser() {
        val currentUser = User(getString(R.string.dummy_user),getString(R.string.dummy_user_img))
        user.value = currentUser
    }

    fun bindCallback(callback: ProfileOptionsCallback) {
        this.callback = callback
    }

    fun getData() {
        adapter.submitList(
            listOf(
                ProfileOption(getString(R.string.favorites), R.drawable.ic_heart),
                ProfileOption(getString(R.string.bookmarks), R.drawable.ic_bookmark),
                ProfileOption(getString(R.string.settings), R.drawable.ic_settings)
            )
        )
    }

    override fun onOptionTap(option: ProfileOption) = callback.onOptionTap(option)
}