package com.cheise_proj.data.extension

import com.cheise_proj.data.mapper.UserMapper
import com.cheise_proj.data.model.User
import com.cheise_proj.domain.entities.UserEntity

internal fun User.asObject() = UserMapper.toModel(this)

internal fun UserEntity.asModel() = UserMapper.fromObject(this)