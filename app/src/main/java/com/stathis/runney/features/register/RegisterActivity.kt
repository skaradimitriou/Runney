package com.stathis.runney.features.register

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityRegisterBinding
import com.stathis.runney.features.dashboard.MainActivity

class RegisterActivity : AbstractActivity() {

    private lateinit var binding : ActivityRegisterBinding
    private lateinit var viewModel : RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun startOps() {
        binding.registerBtn.setOnClickListener {
            val email = binding.emailInputField.text.toString()
            val pass = binding.passInputField.text.toString()
            val pass_conf = binding.passConfInputField.text.toString()

            when(pass == pass_conf){
                true -> viewModel.validateData(email,pass)
                false -> Unit //handle error case with appropriate messages
            }
        }

        viewModel.userRegisted.observe(this, Observer {
            when(it){
                true -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                false -> {} // throw some kind of error
            }
        })
    }

    override fun stopOps() = viewModel.userRegisted.removeObservers(this)
}