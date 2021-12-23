package com.iwan.plasmahero_mobile.data.source.remote.api

import com.iwan.plasmahero_mobile.data.source.remote.posts.*
import com.iwan.plasmahero_mobile.data.source.remote.responses.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

//const val BASE_URL = "http://192.168.0.102:8000/api/"
//const val BASE_URL = "http://172.16.80.117:8000/api/"
const val BASE_URL = "http://192.168.0.108:8000/api/"
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

    @GET("events")
    fun getEvents() : Call<EventResponse>

    @GET("faqs")
    fun getFaqs() : Call<FaqResponse>

    @GET
    fun getProfileById(
            @Url url: String,
            @Header("Authorization") token: String
    ) : Call<ProfileResponse>

    @GET
    fun getDonorHistoryById(
        @Url url: String,
        @Header("Authorization") token: String
    ) : Call<DonorHistoryResponse>

    @GET
    fun getPosterById(
        @Url url: String,
        @Header("Authorization") token: String
    ) : Call<PosterResponse>

    @POST("donors/evidence")
    fun createDonorHistory(
            @Body data: DonorEvidencePost,
            @Header("Authorization") token: String
    ) : Call<DonorEvidenceResponse>
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
