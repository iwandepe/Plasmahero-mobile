package com.iwan.plasmahero_mobile.ui.register

import android.annotation.SuppressLint
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
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.entities.User
import com.iwan.plasmahero_mobile.data.source.remote.posts.RegisterPost

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel

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
        registerViewModel = ViewModelProvider(this).get(com.iwan.plasmahero_mobile.ui.register.RegisterViewModel::class.java)

        val etName = view.findViewById<EditText>(R.id.etRegsiterName)
        val etUsername = view.findViewById<EditText>(R.id.etRegisterUsername)
        val etPassword = view.findViewById<EditText>(R.id.etRegisterPassword)
        val etConfirmPassword = view.findViewById<EditText>(R.id.etRegisterConfirmPassword)
        val btnRegister = view.findViewById<Button>(R.id.btnRegister)
        val loadingProgressBar = view.findViewById<ProgressBar>(R.id.loading)

        registerViewModel.registerFormState.observe(this,
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

        registerViewModel.registerResult.observe(this,
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
                registerViewModel.registerDataChanged(
                        etName.text.toString(),
                        etUsername.text.toString(),
                        etPassword.text.toString(),
                        etConfirmPassword.text.toString()
                )
            }
        }
        etUsername.addTextChangedListener(afterTextChangedListener)
        etPassword.addTextChangedListener(afterTextChangedListener)
        etPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val registerPost = RegisterPost(etName.text.toString(), etUsername.text.toString(), etPassword.text.toString(), etConfirmPassword.text.toString())
                registerViewModel.register(registerPost)
            }
            false
        }

        btnRegister.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            val registerPost = RegisterPost(etName.text.toString(), etUsername.text.toString(), etPassword.text.toString(), etConfirmPassword.text.toString())
            registerViewModel.register(registerPost)
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