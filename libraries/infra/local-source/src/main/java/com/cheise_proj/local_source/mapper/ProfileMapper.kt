package com.cheise_proj.local_source.mapper

import com.cheise_proj.data.mapper.Mapper
import com.cheise_proj.data.model.Profile
import com.cheise_proj.local_source.model.ProfileEntity

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
            education = obj.education
            subject = obj.subject
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
            subject = model.subject
            userId = model.userId
        }
    }
}