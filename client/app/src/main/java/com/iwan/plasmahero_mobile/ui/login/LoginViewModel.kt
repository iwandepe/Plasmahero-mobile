package com.iwan.plasmahero_mobile.ui.login

import android.content.Context
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iwan.plasmahero_mobile.R
import com.iwan.plasmahero_mobile.data.entities.User
import com.iwan.plasmahero_mobile.data.source.remote.RemoteDataSource
import com.iwan.plasmahero_mobile.data.source.remote.posts.LoginPost
import com.iwan.plasmahero_mobile.data.source.remote.responses.LoginResponse
import com.iwan.plasmahero_mobile.utils.SessionManager
import com.iwan.plasmahero_mobile.utils.SessionManager.email
import com.iwan.plasmahero_mobile.utils.SessionManager.name
import com.iwan.plasmahero_mobile.utils.SessionManager.token
import com.iwan.plasmahero_mobile.utils.SessionManager.userId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel() : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(context: Context, data: LoginPost) {
        Log.v("LoginPost", data.toString());
        val call = RemoteDataSource.login(data)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                Log.v("Response", response.body().toString())
                if (response.body()?.success == true) {
                    val user = User(
                            id = response.body()?.data?.id,
                            name = response.body()?.data?.name,
                            email = response.body()?.data?.email,
                            token = response.body()?.data?.token
                    )
                    _loginResult.value = LoginResult(success = user)

                    val prefs = SessionManager.getSharedPreferences(context)
                    prefs.token = user.token
                    prefs.userId = user.id!!
                    prefs.name = user.name
                    prefs.email = user.email
                } else {
                    Log.d("Response", "Response Login Unsuccessfull")
                    _loginResult.value = LoginResult(error = R.string.login_failed)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("Response", "Response Login Unsuccessfull")
                Log.d("Response", t.message.toString())
                _loginResult.value = LoginResult(error = R.string.login_failed)
            }
        })
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
        return Patterns.EMAIL_ADDRESS.matcher(username).matches()
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}