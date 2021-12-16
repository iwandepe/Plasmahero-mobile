package com.iwan.plasmahero_mobile.data.source.remote.posts

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DonorEvidencePost(
        @SerializedName("user_id")
        @Expose
        val userId: Int,

        @SerializedName("udd")
        @Expose
        val udd: String?,

        @SerializedName("donor_evidence")
        @Expose
        val donorEvidence: String?,
)