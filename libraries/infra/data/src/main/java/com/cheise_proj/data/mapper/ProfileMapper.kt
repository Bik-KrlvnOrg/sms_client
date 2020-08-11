package com.cheise_proj.data.mapper

import com.cheise_proj.data.model.Profile
import com.cheise_proj.domain.entities.ProfileEntity

internal object ProfileMapper : Mapper<Profile, ProfileEntity> {
    override fun fromObject(obj: ProfileEntity): Profile {
        return Profile(
            id = obj.id,
            regNo = obj.regNo,
            gender = obj.gender,
            dob = obj.dob,
            bloodGroup = obj.bloodGroup,
            address = obj.address,
            name = obj.name,
            avatar = obj.avatar,
            username = obj.username,
            className = obj.className
        ).apply {
            father = obj.father
            mother = obj.mother
            contact = obj.contact
            email = obj.email
            department = obj.department
            education = obj.education
            userId = obj.userId
        }
    }

    override fun toModel(model: Profile): ProfileEntity {
        return ProfileEntity(
            id = model.id,
            regNo = model.regNo,
            gender = model.gender,
            dob = model.dob,
            bloodGroup = model.bloodGroup,
            address = model.address,
            name = model.name,
            avatar = model.avatar,
            username = model.username,
            className = model.className
        ).apply {
            father = model.father
            mother = model.mother
            contact = model.contact
            email = model.email
            department = model.department
            education = model.education
            userId = model.userId
        }
    }
}