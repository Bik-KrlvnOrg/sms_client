package com.cheise_proj.local_source.utils

import com.cheise_proj.data.model.User
import com.cheise_proj.local_source.model.UserEntity

internal object FakeUser {
    fun getUserEntity(): UserEntity {
        return UserEntity(
            id = 1,
            accessToken = "any_access_token",
            refreshToken = "any_refresh_token",
            password = "any_password",
            username = "any_username",
            type = "any_type",
            avatarUrl = "any_avatar_url",
            schoolId = 1
        )
    }

    fun getUser(): User {
        return User(
            id = 1,
            username = "any_username",
            schoolId = 1,
            avatarUrl = "any_avatar",
            type = "any_type"
        ).apply {
            password = "any_password"
            accessToken = "any_access_token"
            refreshToken = "any_refresh_token"
        }
    }
}