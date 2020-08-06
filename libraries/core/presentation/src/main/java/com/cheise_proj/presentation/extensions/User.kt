package com.cheise_proj.presentation.extensions

import com.cheise_proj.domain.entities.ProfileEntity
import com.cheise_proj.domain.entities.UserEntity
import com.cheise_proj.presentation.mapper.user.ProfileMapper
import com.cheise_proj.presentation.mapper.user.UserMapper
import com.cheise_proj.presentation.model.Profile
import com.cheise_proj.presentation.model.User

internal fun UserEntity.toModel() = UserMapper().fromEntity(this)

internal fun User.toEntity() = UserMapper().toModel(this)


internal fun Profile.asEntity() = ProfileMapper.toModel(this)

internal fun ProfileEntity.asModel() = ProfileMapper.fromEntity(this)