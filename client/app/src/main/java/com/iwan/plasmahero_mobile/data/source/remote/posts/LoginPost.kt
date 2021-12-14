package com.iwan.plasmahero_mobile.data.source.remote.posts

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginPost(
        @SerializedName("email")
        @Expose
        val email: String?,

        @SerializedName("password")
        @Expose
        val password: String?
)