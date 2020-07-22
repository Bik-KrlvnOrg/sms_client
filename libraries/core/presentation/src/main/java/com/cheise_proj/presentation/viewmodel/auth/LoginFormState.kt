package com.cheise_proj.presentation.viewmodel.auth

/**
 * Data validation state of the login form.
 */
data class LoginFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val userTypeError: Int? = null,
    val isDataValid: Boolean = false
)