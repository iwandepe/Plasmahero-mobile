package com.iwan.plasmahero_mobile.data.source.remote.api

import com.iwan.plasmahero_mobile.data.source.remote.posts.LoginPost
import com.iwan.plasmahero_mobile.data.source.remote.responses.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URL = "http://192.168.0.102:8000/api/"

interface ApiService {
    @POST("login")
    fun login(
            @Body data: LoginPost
    ): Call<LoginResponse>
}

object DataService {
    fun create(): ApiService {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        return retrofit.create(ApiService::class.java)
    }
}
