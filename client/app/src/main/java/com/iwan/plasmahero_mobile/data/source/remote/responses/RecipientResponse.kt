package com.iwan.plasmahero_mobile.data.source.remote.responses

import com.google.gson.annotations.SerializedName

data class RecipientResponse(

	@field:SerializedName("data")
	val data: RecipientData? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)

data class RecipientData(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("blood_type")
	val bloodType: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("hospital_city")
	val hospitalCity: String? = null,

	@field:SerializedName("hospital_letter_path")
	val hospitalLetterPath: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("hospital_name")
	val hospitalName: String? = null,

	@field:SerializedName("blood_rhesus")
	val bloodRhesus: String? = null
)
