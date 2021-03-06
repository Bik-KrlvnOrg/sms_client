package com.cheise_proj.local_source.extension

import com.cheise_proj.data.model.User
import com.cheise_proj.local_source.mapper.UserMapper
import com.cheise_proj.local_source.model.UserEntity


internal fun UserEntity.asModel() = UserMapper.fromObject(this)

internal fun User.asEntity() = UserMapper.toModel(this)