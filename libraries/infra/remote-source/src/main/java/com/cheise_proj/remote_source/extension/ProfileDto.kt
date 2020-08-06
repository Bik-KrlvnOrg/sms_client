package com.cheise_proj.remote_source.extension

import com.cheise_proj.data.model.Profile
import com.cheise_proj.remote_source.mapper.StaffProfileMapper
import com.cheise_proj.remote_source.mapper.StudentProfileMapper
import com.cheise_proj.remote_source.model.StaffProfileDto
import com.cheise_proj.remote_source.model.StudentProfileDto


internal fun StudentProfileDto.asModel() = StudentProfileMapper.toModel(this)
internal fun Profile.asProfileDto() = StudentProfileMapper.fromObject(this)


internal fun StaffProfileDto.asModel() = StaffProfileMapper.toModel(this)

internal fun Profile.asStaffDto() = StaffProfileMapper.fromObject(this)

