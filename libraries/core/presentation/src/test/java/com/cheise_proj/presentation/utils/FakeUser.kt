package com.cheise_proj.presentation.utils

import com.cheise_proj.domain.entities.UserType
import com.cheise_proj.presentation.model.Profile
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

    fun getProfile(): Profile{
        return Profile(
            id = 1,
            username = "any_username",
            avatar = "http://any_url",
            name = "any_name",
            address = "any_address",
            bloodGroup = "O+|any",
            dob = "2020-04-12",
            gender = "any_gender",
            regNo = "any_uuid",
            className = "any_class_name"
        )
    }
}