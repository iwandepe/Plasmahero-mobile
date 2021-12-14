package com.iwan.plasmahero_mobile.data.source.remote.posts

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class DonorPost(
        @SerializedName("user_id")
        @Expose
        val userId: Int?,

        @SerializedName("address")
        @Expose
        val address: String?,

        @SerializedName("city")
        @Expose
        val city: String?,

        @SerializedName("age")
        @Expose
        val age: Int?,

        @SerializedName("phone")
        @Expose
        val phone: String?,

        @SerializedName("gender")
        @Expose
        val gender: String?,

        @SerializedName("blood_type")
        @Expose
        val bloodType: String?,

        @SerializedName("blood_rhesus")
        @Expose
        val bloodRhesus: String?,

        @SerializedName("weight")
        @Expose
        val weight: Int?,

        @SerializedName("negative_test_date")
        @Expose
        val negativeTestDate: String,

        @SerializedName("negative_evidence")
        @Expose
        val negativeEvidence: String?,

        @SerializedName("positive_evidence")
        @Expose
        val positiveEvidence: String?,
)