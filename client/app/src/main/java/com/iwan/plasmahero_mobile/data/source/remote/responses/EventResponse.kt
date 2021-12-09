package com.iwan.plasmahero_mobile.data.source.remote.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EventResponse(
        @field:SerializedName("data")
        val data: List<EventData>? = null,

        @field:SerializedName("success")
        val success: Boolean? = null
)

data class EventData(
        @SerializedName("title")
        var title: String? = null,

        @SerializedName("date")
        var date: String? = null,

        @SerializedName("desc")
        var desc: String? = null,

        @SerializedName("imgUrl")
        var imgUrl: String? = null,
)
