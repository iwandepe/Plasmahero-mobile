package com.iwan.plasmahero_mobile.data.source.remote.posts

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterPost(
        @SerializedName("name")
        @Expose
        val name: String?,

        @SerializedName("email")
        @Expose
        val email: String?,

        @SerializedName("password")
        @Expose
        val password: String?,

        @SerializedName("confirm_password")
        @Expose
        val confirmPassword: String?
)