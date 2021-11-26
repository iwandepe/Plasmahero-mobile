package com.iwan.plasmahero_mobile.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.google.firebase.auth.FirebaseAuth

import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.model.LoggedInUser

class LoginViewModel() : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val user = LoggedInUser(
                                it.getResult()?.user?.uid.toString(),
                                it.getResult()?.user?.displayName ?: "Do not set"
                        )

                        println("login succesfull")
                        println(user)
                        _loginResult.value = LoginResult(success = LoggedInUserView(displayName = user.displayName))
                    } else {
                        println("login not successfull")
                        _loginResult.value = LoginResult(error = R.string.login_failed)

                    }
                }
                .addOnFailureListener {
                    println("login on failure")
                    return@addOnFailureListener
                }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}