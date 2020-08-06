package com.cheise_proj.remote_source.mapper

import com.cheise_proj.data.mapper.Mapper
import com.cheise_proj.data.model.Profile
import com.cheise_proj.remote_source.model.StaffProfileDto

internal object StaffProfileMapper : Mapper<StaffProfileDto, Profile> {
    override fun fromObject(obj: Profile): StaffProfileDto {
        return StaffProfileDto(
            profile = StaffProfileDto.Profile(
                    username = obj.username,
            address = obj.address,
            avatar = obj.avatar,
            name = obj.name,
            bloodGroup = obj.bloodGroup,
            dob = obj.dob,
            gender = obj.gender,
            regNo = obj.regNo,
            contact = obj.contact ?: "",
            classX = obj.className,
            email = obj.email ?: "",
            department = obj.department ?: "",
            education = obj.education ?: "",
            subject = obj.subject ?: ""
        )
        )
    }

    override fun toModel(model: StaffProfileDto): Profile {
        val data = model.profile
        return Profile(
            id = -1,
            regNo = data.regNo,
            gender = data.gender,
            dob = data.dob,
            bloodGroup = data.bloodGroup,
            name = data.name,
            avatar = data.avatar,
            address = data.address,
            username = data.username,
            className = data.classX
        )
    }
}