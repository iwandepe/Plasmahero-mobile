package com.iwan.plasmahero_mobile.ui.register

import com.iwan.plasmahero_mobile.data.entities.User

/**
 * Authentication result : success (user details) or error message.
 */
data class RegisterResult(
    val success: User? = null,
    val error: Int? = null
)