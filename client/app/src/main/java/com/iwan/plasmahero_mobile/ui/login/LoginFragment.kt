package com.iwan.plasmahero_mobile.ui.login

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
import androidx.navigation.fragment.findNavController
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.entities.User

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProvider(this).get(com.iwan.plasmahero_mobile.ui.login.LoginViewModel::class.java)

        val etUsername = view.findViewById<EditText>(R.id.etLoginUsername)
        val etPassword = view.findViewById<EditText>(R.id.etLoginPassword)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val btnToRegister = view.findViewById<Button>(R.id.btnToRegister)
        val loadingProgressBar = view.findViewById<ProgressBar>(R.id.loading)

        loginViewModel.loginFormState.observe(this,
                Observer { loginFormState ->
                    if (loginFormState == null) {
                        return@Observer
                    }
                    btnLogin.isEnabled = loginFormState.isDataValid
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

        btnLogin.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            loginViewModel.login(
                    etUsername.text.toString(),
                    etPassword.text.toString()
            )
        }

        btnToRegister.setOnClickListener {
            Toast.makeText(requireContext(), "Daftar di-klik", Toast.LENGTH_LONG).show()
            val navController = findNavController()
            navController.navigate(R.id.action_navigation_login_to_navigation_register)
        }
    }

    private fun updateUiWithUser(model: User) {
        val welcome = getString(R.string.welcome) + model.name
        // TODO : initiate successful logged in experience
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, welcome, Toast.LENGTH_LONG).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }
}


/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}