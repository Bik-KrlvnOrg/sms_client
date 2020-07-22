package com.cheise_proj.data.mapper

import com.cheise_proj.data.model.User
import com.cheise_proj.domain.entities.UserEntity
import com.cheise_proj.domain.entities.UserType

internal object UserMapper : Mapper<User, UserEntity> {
    override fun fromObject(obj: UserEntity): User {
        return User(
            id = obj.id,
            username = obj.username,
            avatarUrl = obj.avatarUrl,
            type = obj.type.name,
            schoolId = obj.schoolId
        ).apply {
            accessToken = null
            refreshToken = null
        }
    }

    override fun toModel(model: User): UserEntity {
        return UserEntity(
            id = model.id,
            schoolId = model.schoolId,
            type = UserType.valueOf(model.type),
            avatarUrl = model.avatarUrl,
            username = model.username
        )
    }

}