package com.stathis.runney.features.newsDetails

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.stathis.runney.abstraction.AbstractViewModel
import com.stathis.runney.models.News

class NewsViewModel(app : Application) : AbstractViewModel(app) {

    private val firestore by lazy { FirebaseFirestore.getInstance() }
    private val auth by lazy { FirebaseAuth.getInstance() }
    val isFavorite = MutableLiveData<Boolean>()
    var favoriteList = mutableListOf<News>()

    fun checkIfFavorite(news: News) {
        firestore.collection("favorites")
            .document(auth.currentUser!!.uid).get().addOnCompleteListener { task ->
                when (task.isSuccessful) {
                    true -> {
                        val result = task.result

                        result?.data?.toList()?.forEach {
                            val json = Gson().toJsonTree(it.second)
                            favoriteList = Gson().fromJson(json, Array<News>::class.java).toMutableList()
                        }

                        when (favoriteList.contains(news)) {
                            true -> isFavorite.value = true
                            false -> isFavorite.value = false
                        }
                    }
                }
            }
    }

    fun addToFavorites(news: News) {
        when (favoriteList.contains(news)) {
            true -> Unit // doc exists in favorites
            false -> {
                favoriteList.add(0, news)

                val docRef = firestore.collection("favorites").document(auth.currentUser!!.uid)
                val data = hashMapOf("favoriteList" to favoriteList)

                docRef.set(data).addOnSuccessListener {
                    checkIfFavorite(news)
                }
            }
        }
    }

    fun removeFromFavorites(news: News) {
        favoriteList.remove(news)

        val docRef = firestore.collection("favorites").document(auth.currentUser!!.uid)
        val data = hashMapOf("favoriteList" to favoriteList)

        docRef.set(data).addOnSuccessListener {
            checkIfFavorite(news)
        }
    }
}