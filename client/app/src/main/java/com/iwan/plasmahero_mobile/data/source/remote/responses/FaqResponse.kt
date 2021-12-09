package com.iwan.plasmahero_mobile.data.source.remote.responses

import com.google.gson.annotations.SerializedName

data class FaqResponse(
        @field:SerializedName("data")
        val data: List<FaqData>? = null,

        @field:SerializedName("success")
        val success: Boolean? = null
)

data class FaqData(
        @SerializedName("id")
        val id: Int? = null,

        @SerializedName("q")
        val question: String? = null,

        @SerializedName("a")
        val answer: String? = null,

        @SerializedName("source")
        val src: String? = null
)


