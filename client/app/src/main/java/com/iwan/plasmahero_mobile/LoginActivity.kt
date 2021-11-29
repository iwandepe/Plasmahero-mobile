package com.iwan.plasmahero_mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

////    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
    }


////        val etUsername = findViewById<EditText>(R.id.etLoginUsername)
////        val etPassword = findViewById<EditText>(R.id.etLoginPassword)
////        val btnLogin = findViewById<Button>(R.id.btnLogin)
////        val btnToRegister = findViewById<Button>(R.id.btnToRegister)
////        val loading = findViewById<ProgressBar>(R.id.loading)
////
////        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
////
////        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
////            val loginState = it ?: return@Observer
////
////            // disable login button unless both username / password is valid
////            btnLogin.isEnabled = loginState.isDataValid
////
////            if (loginState.usernameError != null) {
////                etUsername.error = getString(loginState.usernameError)
////            }
////            if (loginState.passwordError != null) {
////                etPassword.error = getString(loginState.passwordError)
////            }
////        })
////
////        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
////            val loginResult = it ?: return@Observer
////
////            loading.visibility = View.GONE
////            if (loginResult.error != null) {
////                showLoginFailed(loginResult.error)
////            }
////            if (loginResult.success != null) {
////                updateUiWithUser(loginResult.success)
////                setResult(RESULT_OK)
////
////                //Complete and destroy login activity once successful
////                finish()
////
////                val intent = Intent(this, HomeActivity::class.java)
////                startActivity(intent)
////            }
////        })
////
////        etUsername.afterTextChanged {
////            loginViewModel.loginDataChanged(
////                    etUsername.text.toString(),
////                    etPassword.text.toString()
////            )
////        }
////
////        etPassword.apply {
////            afterTextChanged {
////                loginViewModel.loginDataChanged(
////                        etUsername.text.toString(),
////                        etPassword.text.toString()
////                )
////            }
////
////            setOnEditorActionListener { _, actionId, _ ->
////                when (actionId) {
////                    EditorInfo.IME_ACTION_DONE ->
////                        loginViewModel.login(
////                                etUsername.text.toString(),
////                                etPassword.text.toString()
////                        )
////                }
////                false
////            }
////
////            btnLogin.setOnClickListener {
////                loading.visibility = View.VISIBLE
////                loginViewModel.login(etUsername.text.toString(), etPassword.text.toString())
////            }
////        }
//    }
//
//    private fun updateUiWithUser(model: LoggedInUserView) {
//        val welcome = getString(R.string.welcome)
//        val displayName = model.displayName
//        // TODO : initiate successful logged in experience
//        Toast.makeText(
//                applicationContext,
//                "$welcome $displayName",
//                Toast.LENGTH_LONG
//        ).show()
//    }
//
//    private fun showLoginFailed(@StringRes errorString: Int) {
//        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
//    }
}
