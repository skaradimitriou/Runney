package com.stathis.runney.features.raceDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.stathis.runney.models.News
import com.stathis.runney.models.RunningRace

class RaceDetailsViewModel : ViewModel(){

    private val firestore by lazy { FirebaseFirestore.getInstance() }
    private val auth by lazy { FirebaseAuth.getInstance() }
    val isFavorite = MutableLiveData<Boolean>()
    var favoriteList = mutableListOf<RunningRace>()

    fun checkIfFavorite(race: RunningRace) {
        firestore.collection("favorite_races")
            .document(auth.currentUser!!.uid).get().addOnCompleteListener { task ->
                when (task.isSuccessful) {
                    true -> {
                        val result = task.result

                        result?.data?.toList()?.forEach {
                            val json = Gson().toJsonTree(it.second)
                            favoriteList = Gson().fromJson(json, Array<RunningRace>::class.java).toMutableList()
                        }

                        when (favoriteList.contains(race)) {
                            true -> isFavorite.value = true
                            false -> isFavorite.value = false
                        }
                    }
                }
            }
    }

    fun addToFavorites(race: RunningRace) {
        when (favoriteList.contains(race)) {
            true -> Unit // doc exists in favorites
            false -> {
                favoriteList.add(0, race)

                val docRef = firestore.collection("favorite_races").document(auth.currentUser!!.uid)
                val data = hashMapOf("favoriteList" to favoriteList)

                docRef.set(data).addOnSuccessListener {
                    checkIfFavorite(race)
                }
            }
        }
    }

    fun removeFromFavorites(race: RunningRace) {
        favoriteList.remove(race)

        val docRef = firestore.collection("favorite_races").document(auth.currentUser!!.uid)
        val data = hashMapOf("favoriteList" to favoriteList)

        docRef.set(data).addOnSuccessListener {
            checkIfFavorite(race)
        }
    }
}
