package com.stathis.runney.abstraction

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class AbstractFragment(layoutId : Int) : Fragment(layoutId) {

    abstract fun init()
    abstract fun startOps()
    abstract fun stopOps()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
        startOps()
    }

    override fun onStop() {
        stopOps()
        super.onStop()
    }
}