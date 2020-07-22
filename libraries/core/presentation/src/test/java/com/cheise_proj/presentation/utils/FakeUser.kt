package com.cheise_proj.presentation.utils

import com.cheise_proj.domain.entities.UserType
import com.cheise_proj.presentation.model.User

internal object FakeUser {
    fun getUser(): User {
        return User(
            id = 1,
            username = "any_username",
            schoolId = 1,
            type = UserType.ADMIN,
            avatarUrl = "http://any_url"
        )
    }
}