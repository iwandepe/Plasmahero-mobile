package com.iwan.plasmahero_mobile.data.source.remote.responses

import com.google.gson.annotations.SerializedName

data class PosterResponse(
        @SerializedName("data")
        val data: PosterData? = null,

        @SerializedName("success")
        val success: Boolean? = null,

        @SerializedName("message")
        val message: String? = null
)

data class PosterData(
        @SerializedName("poster_url")
        val posterUrl: String? = null,
)