package com.cheise_proj.data.mapper

import com.cheise_proj.data.model.User
import com.cheise_proj.domain.entities.UserEntity

internal object UserMapper : Mapper<User, UserEntity> {
    override fun fromObject(obj: UserEntity): User {
        return User(
            id = obj.id,
            username = obj.username,
            avatarUrl = obj.avatarUrl,
            type = obj.type,
            schoolId = obj.schoolId
        )
    }

    override fun toModel(model: User): UserEntity {
        return UserEntity(
            id = model.id,
            schoolId = model.schoolId,
            type = model.type,
            avatarUrl = model.avatarUrl,
            username = model.username
        )
    }

}