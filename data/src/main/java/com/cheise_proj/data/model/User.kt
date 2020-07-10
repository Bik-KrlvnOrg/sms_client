package com.cheise_proj.data.model

import com.cheise_proj.domain.entities.UserType

 data class User(
    val id: Int,
    var username: String,
    var avatarUrl: String,
    val schoolId: Int,
    val type: UserType
)


