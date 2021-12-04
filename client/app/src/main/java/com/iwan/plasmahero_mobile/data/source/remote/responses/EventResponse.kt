package com.iwan.plasmahero_mobile.data.source.remote.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EventResponse(
        @SerializedName("title")
        @Expose
        var title: String? = null,

        @SerializedName("date")
        @Expose
        var date: String? = null,

        @SerializedName("desc")
        @Expose
        var desc: String? = null,

        @SerializedName("imgUrl")
        @Expose
        var imgUrl: String? = null,
)
