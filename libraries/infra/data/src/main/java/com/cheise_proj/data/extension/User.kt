package com.cheise_proj.data.extension

import com.cheise_proj.data.mapper.ProfileMapper
import com.cheise_proj.data.mapper.UserMapper
import com.cheise_proj.data.model.Profile
import com.cheise_proj.data.model.User
import com.cheise_proj.domain.entities.ProfileEntity
import com.cheise_proj.domain.entities.UserEntity

internal fun User.asEntity() = UserMapper.toModel(this)

internal fun UserEntity.asModel() = UserMapper.fromObject(this)

internal fun Profile.asEntity() = ProfileMapper.toModel(this)

internal fun ProfileEntity.asModel() = ProfileMapper.fromObject(this)