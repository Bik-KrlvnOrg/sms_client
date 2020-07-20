package utils

import com.cheise_proj.data.model.User
import com.cheise_proj.domain.entities.UserType

internal object FakeUser{
    fun getUser():User{
        return User(
            id = 1,
            username = "any_username",
            avatarUrl = "http://any_url",
            type = UserType.STAFF.name,
            schoolId = 1,
            password = ""
        )
    }
}