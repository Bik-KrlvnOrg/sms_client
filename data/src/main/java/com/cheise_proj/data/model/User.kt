package com.cheise_proj.data.model

data class User(
    val id: Int,
    var username: String,
    var avatarUrl: String,
    val schoolId: Int,
    val type: String
) {
    constructor() : this(0, "", "", 0, "")
    var password:String? = null
    var accessToken: String? = null
    var refreshToken: String? = null
}


