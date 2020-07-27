package com.cheise_proj.local_source.mapper

import com.cheise_proj.data.mapper.Mapper
import com.cheise_proj.data.model.User
import com.cheise_proj.local_source.model.UserEntity

internal object UserMapper : Mapper<User, UserEntity> {
    override fun fromObject(obj: UserEntity): User {
        return User(
            id = obj.id,
            username = obj.username,
            type = obj.type,
            avatarUrl = obj.avatarUrl,
            schoolId = obj.schoolId
        ).apply {
            password = obj.password
            accessToken = obj.accessToken
            refreshToken = obj.refreshToken
        }
    }

    override fun toModel(model: User): UserEntity {
        return UserEntity(
            id = model.id,
            schoolId = model.schoolId,
            avatarUrl = model.avatarUrl,
            type = model.type,
            username = model.username,
            password = model.password ?: "",
            refreshToken = model.refreshToken ?: "",
            accessToken = model.accessToken ?: ""
        )
    }
}