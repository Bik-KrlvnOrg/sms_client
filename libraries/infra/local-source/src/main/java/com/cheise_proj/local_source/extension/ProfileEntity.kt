package com.cheise_proj.local_source.extension

import com.cheise_proj.data.model.Profile
import com.cheise_proj.local_source.mapper.ProfileMapper
import com.cheise_proj.local_source.model.ProfileEntity

internal fun ProfileEntity.asModel() = ProfileMapper.fromObject(this)

internal fun Profile.asEntity() = ProfileMapper.toModel(this)