package com.stathis.runney.features.register

import android.os.Bundle
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityRegisterBinding

class RegisterActivity : AbstractActivity() {

    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        //
    }

    override fun startOps() {
        //
    }

    override fun stopOps() {
        //
    }
}