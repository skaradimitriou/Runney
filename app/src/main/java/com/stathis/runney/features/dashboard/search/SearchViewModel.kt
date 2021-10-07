package com.stathis.runney.features.dashboard.search

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.stathis.runney.abstraction.LocalModel
import com.stathis.runney.callbacks.SearchScreenCallback
import com.stathis.runney.features.dashboard.search.adapter.SearchAdapter
import com.stathis.runney.models.Query
import com.stathis.runney.models.SearchCategory
import com.stathis.runney.util.TAG

class SearchViewModel : ViewModel(), SearchScreenCallback {

    val firestore = FirebaseFirestore.getInstance()
    val auth by lazy { FirebaseAuth.getInstance() }
    val adapter = SearchAdapter(this)
    val data = MutableLiveData<List<LocalModel>>()
    private var queryList = mutableListOf<LocalModel>()
    private lateinit var callback: SearchScreenCallback

    init {
        getUserQueries()
    }

    fun getUserQueries() {
        firestore.collection("saved_queries")
            .document(auth.currentUser!!.uid).addSnapshotListener { p0, p1 ->
                Log.d("", p0?.data.toString())

                p0?.data?.toList()?.forEach {
                    val json = Gson().toJsonTree(it.second)
                    Log.d("", json.toString())
                    queryList = Gson().fromJson(json, Array<Query>::class.java).toMutableList()

                    Log.d("", queryList.toString())
                }
                data.value = queryList
            }
    }

    fun insertQueryToDb(query: Query) {
        val fRef = firestore.collection("saved_queries").document(auth.currentUser!!.uid)

        when (queryList.size >= 9) {
            true -> {
                queryList.remove(queryList.last())
                queryList.add(0, query)
            }
            false -> queryList.add(0, query)
        }


        val data = hashMapOf<String, Any>(
            "queryList" to queryList
        )

        fRef.set(data).addOnSuccessListener {
            Log.d("TAG", "OK")
        }.addOnFailureListener {
            Log.d("TAG", "NOT OK")
        }
        getUserQueries()
    }

    fun getResultsForQuery(query: String) {
//        firestore.collection("doctors").get().addOnSuccessListener { docs ->
//            val list = arrayListOf<LocalModel>()
//            for (document in docs) {
//                Log.d(TAG, "${document.id} => ${document.data}")
//                val model = document.toObject(LocalModel::class.java)
//                list.add(model)
//            }
//
//            data.value = list
//        }.addOnFailureListener {
//            Log.d(TAG, "Error getting documents: ", it)
//        }
    }

    fun observe(owner : LifecycleOwner){
        data.observe(owner, Observer{
            adapter.submitList(it)
        })
    }

    fun release(owner : LifecycleOwner){
        data.removeObservers(owner)
    }

    fun addCallbacks(callback: SearchScreenCallback) {
        this.callback = callback
    }

    override fun onQueryTap(query: Query) = callback.onQueryTap(query)
}