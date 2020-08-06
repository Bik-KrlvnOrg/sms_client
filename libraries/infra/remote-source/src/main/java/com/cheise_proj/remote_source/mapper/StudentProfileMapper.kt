package com.cheise_proj.remote_source.mapper

import com.cheise_proj.data.mapper.Mapper
import com.cheise_proj.data.model.Profile
import com.cheise_proj.remote_source.model.StudentProfileDto

internal object StudentProfileMapper : Mapper<StudentProfileDto, Profile> {
    override fun fromObject(obj: Profile): StudentProfileDto {
        return StudentProfileDto(
            profile = StudentProfileDto.Profile(
                personal = StudentProfileDto.Profile.Personal(
                    username = obj.username,
                    address = obj.address,
                    avatar = obj.avatar,
                    name = obj.name,
                    bloodGroup = obj.bloodGroup,
                    dob = obj.dob,
                    gender = obj.gender,
                    regNo = obj.regNo,
                    classX = obj.className,
                    section = ""
                ),
                parent = StudentProfileDto.Profile.Parent(
                    father = obj.father ?: "",
                    mother = obj.mother ?: "",
                    contact = obj.contact ?: "",
                    occupation = ""
                )
            )
        )
    }

    override fun toModel(model: StudentProfileDto): Profile {
        val personal = model.profile.personal
        val parent = model.profile.parent
        return Profile(
            username = personal.username,
            regNo = personal.regNo,
            gender = personal.gender,
            dob = personal.dob,
            bloodGroup = personal.bloodGroup,
            name = personal.name,
            avatar = personal.avatar,
            address = personal.address,
            className = personal.classX,
            id = -1
        ).apply {
            father = parent.father
            mother = parent.mother
            contact = parent.contact
        }
    }
}