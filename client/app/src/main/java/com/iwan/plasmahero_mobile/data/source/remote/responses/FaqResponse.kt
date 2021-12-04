package com.iwan.plasmahero_mobile.data.source.remote.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FaqResponse(
        @SerializedName("q")
        @Expose
        var question: String? = null,

        @SerializedName("a")
        @Expose
        var answer: String? = null,
)
