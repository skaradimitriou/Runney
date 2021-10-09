package com.stathis.runney.features.articledetails

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.stathis.runney.abstraction.AbstractViewModel
import com.stathis.runney.models.Article
import com.stathis.runney.models.News

class ArticleDetailsViewModel(app : Application) : AbstractViewModel(app) {

    private val firestore by lazy { FirebaseFirestore.getInstance() }
    private val auth by lazy { FirebaseAuth.getInstance() }
    val isFavorite = MutableLiveData<Boolean>()
    var favoriteList = mutableListOf<Article>()

    fun checkIfFavorite(article: Article) {
        firestore.collection("favorite_articles")
            .document(auth.currentUser!!.uid).get().addOnCompleteListener { task ->
                when (task.isSuccessful) {
                    true -> {
                        val result = task.result

                        result?.data?.toList()?.forEach {
                            val json = Gson().toJsonTree(it.second)
                            favoriteList = Gson().fromJson(json, Array<Article>::class.java).toMutableList()
                        }

                        when (favoriteList.contains(article)) {
                            true -> isFavorite.value = true
                            false -> isFavorite.value = false
                        }
                    }
                }
            }
    }

    fun addToFavorites(article: Article) {
        when (favoriteList.contains(article)) {
            true -> Unit // doc exists in favorites
            false -> {
                favoriteList.add(0, article)

                val docRef = firestore.collection("favorite_articles").document(auth.currentUser!!.uid)
                val data = hashMapOf("favoriteList" to favoriteList)

                docRef.set(data).addOnSuccessListener {
                    checkIfFavorite(article)
                }
            }
        }
    }

    fun removeFromFavorites(article: Article) {
        favoriteList.remove(article)

        val docRef = firestore.collection("favorite_articles").document(auth.currentUser!!.uid)
        val data = hashMapOf("favoriteList" to favoriteList)

        docRef.set(data).addOnSuccessListener {
            checkIfFavorite(article)
        }
    }
}