package com.iwan.plasmahero_mobile.ui.register

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.entities.User
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.posts.RegisterPost
import com.iwan.plasmahero_mobile.data.source.remote.responses.LoginResponse
import com.iwan.plasmahero_mobile.data.source.remote.responses.RegisterResponse
import com.iwan.plasmahero_mobile.ui.login.LoginResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterViewModel() : ViewModel() {

    private val _loginForm = MutableLiveData<RegisterFormState>()
    val registerFormState: LiveData<RegisterFormState> = _loginForm

    private val _loginResult = MutableLiveData<RegisterResult>()
    val registerResult: LiveData<RegisterResult> = _loginResult

    fun register(data: RegisterPost) {
        val call = RemoteDataSource.register(data)
        call.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                Log.v("Response", response.body().toString())
                _loginResult.value = RegisterResult(success = User(id = 1, name = data.name, email = data.email))
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.d("Reponse", "Response Login Unsuccessfull")
                Log.d("Response", t.message.toString())
                _loginResult.value = RegisterResult(error = R.string.register_failed)
            }
        })
    }

    fun registerDataChanged(name: String, username: String, password: String, confirmPassword: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = RegisterFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = RegisterFormState(passwordError = R.string.invalid_password)
        } else if (isConfirmPasswordValid(password, confirmPassword)) {
            _loginForm.value = RegisterFormState(confirmPasswordError = R.string.invalid_confirm_password)
        } else {
            _loginForm.value = RegisterFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    private fun isConfirmPasswordValid(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }
}