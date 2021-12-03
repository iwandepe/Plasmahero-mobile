package com.iwan.plasmahero_mobile.ui.login

import com.iwan.plasmahero_mobile.data.entities.User

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
        val success: User? = null,
        val error: Int? = null
)