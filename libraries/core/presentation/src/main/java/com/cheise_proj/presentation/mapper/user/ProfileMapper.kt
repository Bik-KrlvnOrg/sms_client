package com.cheise_proj.presentation.mapper.user

import com.cheise_proj.domain.entities.ProfileEntity
import com.cheise_proj.presentation.mapper.Mapper
import com.cheise_proj.presentation.model.Profile

internal object ProfileMapper : Mapper<Profile, ProfileEntity> {
    override fun fromEntity(entity: ProfileEntity): Profile {
        return Profile(
            id = entity.id,
            className = entity.className,
            username = entity.username,
            address = entity.address,
            avatar = entity.avatar,
            name = entity.name,
            bloodGroup = entity.bloodGroup,
            dob = entity.dob,
            gender = entity.gender,
            regNo = entity.regNo
        ).apply {
            father = entity.father
            mother = entity.mother
            department = entity.department
            education = entity.education
            subject = entity.subject
            contact = entity.contact
            userId = entity.userId
        }
    }

    override fun toModel(model: Profile): ProfileEntity {
        return ProfileEntity(
            id = model.id,
            className = model.className,
            username = model.username,
            address = model.address,
            avatar = model.avatar,
            name = model.name,
            bloodGroup = model.bloodGroup,
            dob = model.dob,
            gender = model.gender,
            regNo = model.regNo
        ).apply {
            father = model.father
            mother = model.mother
            department = model.department
            education = model.education
            subject = model.subject
            contact = model.contact
            userId = model.userId
        }
    }
}