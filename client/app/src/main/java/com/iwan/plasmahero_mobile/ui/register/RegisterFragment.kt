package com.iwan.plasmahero_mobile.ui.register

import android.annotation.SuppressLint
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.iwan.plasmahero_mobile.R

class RegisterFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProvider(this).get(com.iwan.plasmahero_mobile.ui.register.LoginViewModel::class.java)

        val etUsername = view.findViewById<EditText>(R.id.etRegisterUsername)
        val etPassword = view.findViewById<EditText>(R.id.etRegisterPassword)
        val etConfirmPassword = view.findViewById<EditText>(R.id.etRegisterConfirmPassword)
        val btnRegister = view.findViewById<Button>(R.id.btnRegister)
        val loadingProgressBar = view.findViewById<ProgressBar>(R.id.loading)

        loginViewModel.loginFormState.observe(this,
                Observer { loginFormState ->
                    if (loginFormState == null) {
                        return@Observer
                    }
                    btnRegister.isEnabled = loginFormState.isDataValid
                    loginFormState.usernameError?.let {
                        etUsername.error = getString(it)
                    }
                    loginFormState.passwordError?.let {
                        etPassword.error = getString(it)
                    }
                })

        loginViewModel.loginResult.observe(this,
                Observer { loginResult ->
                    loginResult ?: return@Observer
                    loadingProgressBar.visibility = View.GONE
                    loginResult.error?.let {
                        showLoginFailed(it)
                    }
                    loginResult.success?.let {
                        updateUiWithUser(it)
                    }
                })

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                loginViewModel.loginDataChanged(
                        etUsername.text.toString(),
                        etPassword.text.toString()
                )
            }
        }
        etUsername.addTextChangedListener(afterTextChangedListener)
        etPassword.addTextChangedListener(afterTextChangedListener)
        etPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(
                        etUsername.text.toString(),
                        etPassword.text.toString()
                )
            }
            false
        }

        btnRegister.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            loginViewModel.login(
                    etUsername.text.toString(),
                    etPassword.text.toString()
            )
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome) + model.displayName
        // TODO : initiate successful logged in experience
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, welcome, Toast.LENGTH_LONG).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }
}