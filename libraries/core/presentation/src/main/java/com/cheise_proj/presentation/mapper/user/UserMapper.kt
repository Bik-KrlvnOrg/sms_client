package com.cheise_proj.presentation.mapper.user

import com.cheise_proj.domain.entities.UserEntity
import com.cheise_proj.presentation.mapper.Mapper
import com.cheise_proj.presentation.model.User

internal class UserMapper : Mapper<User, UserEntity> {
    override fun fromEntity(entity: UserEntity): User {
        return User(
            id = entity.id,
            avatarUrl = entity.avatarUrl,
            type = entity.type,
            schoolId = entity.schoolId,
            username = entity.username
        )
    }

    override fun toModel(model: User): UserEntity {
        return UserEntity(
            id = model.id,
            avatarUrl = model.avatarUrl,
            type = model.type,
            schoolId = model.schoolId,
            username = model.username
        )
    }
}