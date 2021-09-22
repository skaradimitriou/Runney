package com.stathis.runney.features.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stathis.runney.abstraction.AbstractActivity
import com.stathis.runney.databinding.ActivityLoginBinding
import com.stathis.runney.features.dashboard.MainActivity
import com.stathis.runney.features.forgotpassword.ForgotPasswordActivity
import com.stathis.runney.features.register.RegisterActivity

class LoginActivity : AbstractActivity() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun startOps() {
        binding.loginBtn.setOnClickListener{
            val email = binding.emailInputField.text.toString()
            val pass = binding.passInputField.text.toString()

            viewModel.authenticateUser(email,pass)
        }

        binding.forgotPassword.setOnClickListener{
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        binding.registerBtn.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        viewModel.userAuthenticated.observe(this, Observer {
            when(it){
                true -> startActivity(Intent(this, MainActivity::class.java))
                false -> {} // throw some kind of error to the user
            }
        })

        viewModel.userIsLoggedIn.observe(this, Observer{
            when(it){
                true -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                false -> Unit
            }
        })
    }

    override fun stopOps() = viewModel.userAuthenticated.removeObservers(this)
}