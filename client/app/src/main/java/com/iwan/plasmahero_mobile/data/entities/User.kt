package com.iwan.plasmahero_mobile.data.entities

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class User(
        val id: Int,
        val name: String,
        val email: String
)