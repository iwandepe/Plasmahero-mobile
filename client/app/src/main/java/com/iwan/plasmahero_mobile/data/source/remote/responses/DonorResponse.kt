package com.iwan.plasmahero_mobile.data.source.remote.responses

import com.google.gson.annotations.SerializedName

data class DonorResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)

data class Data(

	@field:SerializedName("is_vaccinated")
	val isVaccinated: Any? = null,

	@field:SerializedName("treatment")
	val treatment: Any? = null,

	@field:SerializedName("negative_evidence_path")
	val negativeEvidencePath: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("vaccine_dose")
	val vaccineDose: Any? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("blood_type")
	val bloodType: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("is_voluntary")
	val isVoluntary: Any? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("weight")
	val weight: Any? = null,

	@field:SerializedName("positive_evidence_path")
	val positiveEvidencePath: String? = null,

	@field:SerializedName("vaccine_name")
	val vaccineName: Any? = null,

	@field:SerializedName("negative_test_date")
	val negativeTestDate: Any? = null,

	@field:SerializedName("symptom")
	val symptom: Any? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("is_donate_regularly")
	val isDonateRegularly: Any? = null,

	@field:SerializedName("is_tranfusion")
	val isTranfusion: Any? = null,

	@field:SerializedName("is_contact_shareable")
	val isContactShareable: Any? = null,

	@field:SerializedName("chronic_disease")
	val chronicDisease: Any? = null,

	@field:SerializedName("age")
	val age: String? = null,

	@field:SerializedName("blood_rhesus")
	val bloodRhesus: String? = null
)
