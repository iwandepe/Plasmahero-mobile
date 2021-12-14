package com.iwan.plasmahero_mobile.ui.register

import android.content.Context
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.entities.User
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.posts.RegisterPost
import com.iwan.plasmahero_mobile.data.source.remote.responses.RegisterResponse
import com.iwan.plasmahero_mobile.ui.login.LoginResult
import com.iwan.plasmahero_mobile.utils.SessionManager
import com.iwan.plasmahero_mobile.utils.SessionManager.email
import com.iwan.plasmahero_mobile.utils.SessionManager.name
import com.iwan.plasmahero_mobile.utils.SessionManager.token
import com.iwan.plasmahero_mobile.utils.SessionManager.userId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel() : ViewModel() {

    private val _register = MutableLiveData<RegisterFormState>()
    val registerFormState: LiveData<RegisterFormState> = _register

    private val _registerResult = MutableLiveData<RegisterResult>()
    val registerResult: LiveData<RegisterResult> = _registerResult

    fun register(context: Context, data: RegisterPost) {
        val call = RemoteDataSource.register(data)
        call.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                Log.d("Response full", response.toString())
                if (response.body()?.success == true) {
                    Log.v("Response success", response.body().toString())
                    val user = User(
                            id = response.body()?.data?.id,
                            name = response.body()?.data?.name,
                            email = response.body()?.data?.email,
                            token = response.body()?.data?.token
                    )
                    _registerResult.value = RegisterResult(success = user)

                    val prefs = SessionManager.getSharedPreferences(context)
                    prefs.token = user.token
                    prefs.userId = user.id!!
                    prefs.name = user.name
                    prefs.email = user.email
                } else {
                    Log.v("Response failed", response.body().toString())
                    _registerResult.value = RegisterResult(error = R.string.register_failed)
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.d("Response", "Register Unsuccessfull")
                Log.d("Response", t.message.toString())
                _registerResult.value = RegisterResult(error = R.string.register_failed)
            }
        })
    }

    fun registerDataChanged(name: String, username: String, password: String, confirmPassword: String) {
        if (!isUserNameValid(username)) {
            _register.value = RegisterFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _register.value = RegisterFormState(passwordError = R.string.invalid_password)
        } else if (!isConfirmPasswordValid(password, confirmPassword)) {
            _register.value = RegisterFormState(confirmPasswordError = R.string.invalid_confirm_password)
        } else {
            _register.value = RegisterFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(username).matches()
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    private fun isConfirmPasswordValid(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }
}