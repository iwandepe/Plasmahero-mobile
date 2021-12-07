package com.iwan.plasmahero_mobile.data.source.remote.api

import com.iwan.plasmahero_mobile.data.model.EventModel
import com.iwan.plasmahero_mobile.data.model.FaqModel
import com.iwan.plasmahero_mobile.data.source.remote.posts.DonorPost
import com.iwan.plasmahero_mobile.data.source.remote.posts.LoginPost
import com.iwan.plasmahero_mobile.data.source.remote.posts.RecipientPost
import com.iwan.plasmahero_mobile.data.source.remote.posts.RegisterPost
import com.iwan.plasmahero_mobile.data.source.remote.responses.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.io.IOException


const val BASE_URL = "http://192.168.0.102:8000/api/"
//private const val BASE_URL = "https://cahindo.xyz/lara/"

interface ApiService {
    @POST("login")
    fun login(
            @Body data: LoginPost
    ): Call<LoginResponse>

    @POST("register")
    fun register(
            @Body data: RegisterPost
    ): Call<RegisterResponse>

    @POST("donors")
    fun createDonor(
        @Body data: DonorPost,
        @Header("Authorization") token: String
    ): Call<DonorResponse>

    @POST("recipients")
    fun createRecipient(
        @Body data: RecipientPost,
        @Header("Authorization") token: String
    ): Call<RecipientResponse>

    @GET("event")
    fun getEvents() : Call<List<EventResponse>>

    @GET("faq")
    fun getFaqs() : Call<List<FaqResponse>>

    @GET
    fun getProfileById(
            @Url url: String,
            @Header("Authorization") token: String
    ) : Call<ProfileResponse>
}

/*
var client = OkHttpClient.Builder().addInterceptor(object : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + "26|fmjIne1YaCNz2Suipld6eEHZfwZKmpPa3SbqNtpE")
                .build()
        return chain.proceed(newRequest)
    }
}).build()
*/

object DataService {
    fun create(): ApiService {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        return retrofit.create(ApiService::class.java)
    }
}
