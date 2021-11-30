package com.iwan.plasmahero_mobile.data.entities

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class User(
        val id: Int? = null,
        val name: String? = null,
        val email: String? = null
)