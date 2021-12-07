package com.iwan.plasmahero_mobile.data.source.remote

import android.util.Log
import com.iwan.plasmahero_mobile.data.source.remote.api.BASE_URL
import com.iwan.plasmahero_mobile.data.source.remote.api.DataService
import com.iwan.plasmahero_mobile.data.source.remote.posts.DonorPost
import com.iwan.plasmahero_mobile.data.source.remote.posts.LoginPost
import com.iwan.plasmahero_mobile.data.source.remote.posts.RecipientPost
import com.iwan.plasmahero_mobile.data.source.remote.posts.RegisterPost
import com.iwan.plasmahero_mobile.data.source.remote.responses.*
import com.iwan.plasmahero_mobile.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

object RemoteDataSource {
    fun login(data: LoginPost): Call<LoginResponse> {
        val apiService = DataService.create()
        val call = apiService.login(data)

        return call
    }

    fun register(data: RegisterPost): Call<RegisterResponse> {

        val apiService = DataService.create()
        val call = apiService.register(data)

        return call
    }

    fun createDonor(data: DonorPost, token: String): Call<DonorResponse> {
        val apiService = DataService.create()
        val call = apiService.createDonor(data, token)

        return call
    }

    fun getProfileById(id: Int, token: String): Call<ProfileResponse> {
        val apiService = DataService.create()
        val url = BASE_URL + "profile/" + id.toString()
        val call = apiService.getProfileById(url, token)

        return call
    }

    fun getDonorHistoryById(id: Int, token: String): Call<DonorHistoryResponse> {
        val apiService = DataService.create()
        val url = BASE_URL + "donors/" + id.toString() + "/histories"
        val call = apiService.getDonorHistoryById(url, token)

        return call
    }

    fun createRecipient(data: RecipientPost, token: String): Call<RecipientResponse> {
        val apiService = DataService.create()
        val call = apiService.createRecipient(data, token)

        return call
    }

    fun getEvent(): Call<List<EventResponse>> {
        val apiService = DataService.create()
        val call = apiService.getEvents()

        return call
    }

    fun getFaq(): Call<List<FaqResponse>> {
        val apiService = DataService.create()
        val call = apiService.getFaqs()

        return call
    }
}