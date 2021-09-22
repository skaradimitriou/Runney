package com.stathis.runney.features.forgotpassword

import android.os.Bundle
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AbstractActivity() {

    private lateinit var binding : ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
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