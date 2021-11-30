package com.iwan.plasmahero_mobile.data.source.remote

import android.util.Log
import com.iwan.plasmahero_mobile.data.source.remote.api.DataService
import com.iwan.plasmahero_mobile.data.source.remote.posts.LoginPost
import com.iwan.plasmahero_mobile.data.source.remote.responses.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

object RemoteDataSource {
    fun login(email: String, password: String): Call<LoginResponse> {
        val data = LoginPost(email, password)

        val apiService = DataService.create()
        val call = apiService.login(data)

        return call
    }
}