package com.iwan.plasmahero_mobile.data.source.remote.responses

import com.google.gson.annotations.SerializedName

data class DonorEvidenceResponse(

	@field:SerializedName("data")
	val data: DonorEvidenceData? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)

data class DonorEvidenceData(

	@field:SerializedName("udd")
	val udd: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("donor_evidence_path")
	val donorEvidencePath: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
