package utils

import com.cheise_proj.domain.entities.ProfileEntity
import com.cheise_proj.domain.entities.UserEntity
import com.cheise_proj.domain.entities.UserType

object FakeUser {
    fun getUser(): UserEntity {
        return UserEntity(
            id = 1,
            username = "any_username",
            avatarUrl = "http://any_url",
            schoolId = 1,
            type = UserType.STUDENT
        )
    }

    fun getProfile(): ProfileEntity {
        return ProfileEntity(
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