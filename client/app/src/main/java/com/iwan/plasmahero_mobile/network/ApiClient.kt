package com.iwan.plasmahero_mobile.network

import com.iwan.plasmahero_mobile.data.model.EventModel
import com.iwan.plasmahero_mobile.data.model.FaqModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class ApiClient {

    companion object {
        const val BASE_URL = "https://cahindo.xyz/lara/"
    }

    private fun retrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun instance() : ApiInterface {
        return retrofit().create(ApiInterface::class.java)

    }

}

interface ApiInterface{

//    @Multipart
//    @POST("imageUpload")
//    fun upload(
//        @Part imagename:MultipartBody.Part
//
//    ) : Call<Default>
//
//    @POST("upload")
//    @FormUrlEncoded
//    fun uploadBase64(
//        @Field("image") base64 : String,
//    ) : Call<Default>

    @GET("event")
    fun getEvents() : Call<List<EventModel.EventValue>>

    @GET("faq")
    fun getFaqs() : Call<List<FaqModel.FaqValue>>


}
