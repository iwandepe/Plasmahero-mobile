package com.iwan.plasmahero_mobile.data.source.remote.posts

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecipientPost(
    @SerializedName("user_id")
    @Expose
    val userId: Int? = null,

    @SerializedName("phone")
    val phone: String? = null,

    @SerializedName("blood_type")
    @Expose
    val bloodType: String? = null,

    @SerializedName("hospital_city")
    @Expose
    val hospitalCity: String? = null,

    @SerializedName("hospital_letter")
    @Expose
    val hospital_letter: String? = null,

    @SerializedName("hospital_name")
    @Expose
    val hospitalName: String? = null,

    @SerializedName("blood_rhesus")
    val bloodRhesus: String? = null
)