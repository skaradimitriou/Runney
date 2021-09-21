package com.stathis.runney.abstraction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class AbstractActivity() : AppCompatActivity() {

    abstract fun init()
    abstract fun startOps()
    abstract fun stopOps()

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        init()
    }

    override fun onPostResume() {
        super.onPostResume()
        startOps()
    }

    override fun onStop() {
        stopOps()
        super.onStop()
    }
}