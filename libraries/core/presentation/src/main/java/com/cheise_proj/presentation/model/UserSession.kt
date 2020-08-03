package com.cheise_proj.presentation.model

data class UserSession(
    val userId: Int,
    val displayName: String?,
    val userType: String?,
    val schoolId: String?
)