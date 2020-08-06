package utils

import com.cheise_proj.data.model.Profile
import com.cheise_proj.data.model.User
import com.cheise_proj.domain.entities.UserType

internal object FakeUser {
    fun getUser(): User {
        return User(
            id = 1,
            username = "any_username",
            avatarUrl = "http://any_url",
            type = UserType.STAFF.name,
            schoolId = 1
        )
    }

    fun getProfile(): Profile {
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