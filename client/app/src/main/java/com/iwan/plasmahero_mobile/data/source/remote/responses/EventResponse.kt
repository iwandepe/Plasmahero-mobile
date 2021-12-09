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
        @SerializedName("judul")
        var title: String? = null,

        @SerializedName("tgl")
        var date: String? = null,

        @SerializedName("deskripsi")
        var desc: String? = null,

        @SerializedName("img_filename")
        var imgUrl: String? = null,
)
