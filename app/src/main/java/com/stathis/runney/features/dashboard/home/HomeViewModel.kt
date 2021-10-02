package com.stathis.runney.features.dashboard.home

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.stathis.runney.R
import com.stathis.runney.abstraction.AbstractViewModel
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.HomeScreenCallback
import com.stathis.runney.features.dashboard.home.adapter.HomeAdapter
import com.stathis.runney.features.dashboard.home.model.HomeItem
import com.stathis.runney.features.dashboard.profile.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(app: Application) : AbstractViewModel(app), HomeScreenCallback {

    val data = MutableLiveData<List<LocalModel>>()
    val user = MutableLiveData<User>()
    val adapter = HomeAdapter(this)
    private lateinit var callback: HomeScreenCallback

    fun bindCallback(callback: HomeScreenCallback) {
        this.callback = callback
    }

    init {
        getUser()
        viewModelScope.launch {
            delay(300)
            getData()
        }
    }

    private fun getUser() {
        val currentUser = User(getString(R.string.dummy_user), getString(R.string.dummy_user_img))
        user.value = currentUser
    }

    private fun getData() {
        val list = listOf(
            HomeItem(getString(R.string.news),R.drawable.ic_heart),
            HomeItem(getString(R.string.article),R.drawable.ic_heart),
            HomeItem(getString(R.string.running_races),R.drawable.ic_heart),
            HomeItem(getString(R.string.something_else),R.drawable.ic_heart))

        data.value = list
    }

    fun observe(owner: LifecycleOwner) {
        data.observe(owner, Observer{
            adapter.submitList(it)
        })
    }

    fun release(owner: LifecycleOwner) {
        data.removeObservers(owner)
    }

    override fun onHomeItemTap(item: HomeItem) = callback.onHomeItemTap(item)
}