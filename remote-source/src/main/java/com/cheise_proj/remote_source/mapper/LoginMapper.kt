package com.cheise_proj.remote_source.mapper

import com.cheise_proj.data.mapper.Mapper
import com.cheise_proj.data.model.User
import com.cheise_proj.remote_source.model.LoginDto

internal object LoginMapper : Mapper<LoginDto, User> {
    override fun fromObject(obj: User): LoginDto {
        return LoginDto(
            accessToken = obj.accessToken!!,
            refreshToken = obj.refreshToken!!
        )
    }

    override fun toModel(model: LoginDto): User {
        return User().apply {
            accessToken = model.accessToken
            refreshToken = model.refreshToken
        }
    }
}