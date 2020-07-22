package com.cheise_proj.presentation.viewmodel.auth

/**
 * User details post authentication that is exposed to the UI
 */
data class LoggedInUserView(
    val displayName: String?,
    var userId:Int?
)