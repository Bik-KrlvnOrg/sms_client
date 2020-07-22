package utils

import com.cheise_proj.domain.entities.UserEntity
import com.cheise_proj.domain.entities.UserType

object FakeUser {
    fun getUser():UserEntity{
        return UserEntity(
            id = 1,
            username = "any_username",
            avatarUrl = "http://any_url",
            schoolId = 1,
            type = UserType.STUDENT
        )
    }
}