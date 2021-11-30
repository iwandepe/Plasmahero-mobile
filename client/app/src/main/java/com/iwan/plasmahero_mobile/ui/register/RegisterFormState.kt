package com.iwan.plasmahero_mobile.ui.register

/**
 * Data validation state of the login form.
 */
data class RegisterFormState(val usernameError: Int? = null,
                             val passwordError: Int? = null,
                             val confirmPasswordError: Int? = null,
                             val isDataValid: Boolean = false)