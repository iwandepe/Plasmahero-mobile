package com.iwan.plasmahero_mobile.data.source.remote.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse(
        @SerializedName("data")
        val data: LoginData? = null,

        @SerializedName("success")
        val success: Boolean? = null,

        @SerializedName("message")
        val message: String? = null
)

data class LoginData(
        @SerializedName("email")
        val email: String? = null,

        @SerializedName("token")
        val token: String? = null,

        @SerializedName("id")
        val id: Int? = null,

        @SerializedName("name")
        val name: String? = null,
)