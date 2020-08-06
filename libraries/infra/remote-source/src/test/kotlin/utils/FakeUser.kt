package utils

import com.cheise_proj.remote_source.model.LoginDto
import com.cheise_proj.remote_source.model.StaffProfileDto
import com.cheise_proj.remote_source.model.StudentProfileDto

object FakeUser {
    fun getLoginDto(): LoginDto {
        return LoginDto(
            accessToken = "any_access_token",
            refreshToken = "any_refresh_token"
        )
    }

    fun getStudentDto(): StudentProfileDto {
        return StudentProfileDto(
            profile = StudentProfileDto.Profile(
                personal = StudentProfileDto.Profile.Personal(
                    username = "any_username",
                    address = "any_address",
                    avatar = "http://any_link",
                    name = "any_name",
                    bloodGroup = "O+|any",
                    dob = "any_dob",
                    gender = "any_gender",
                    regNo = "any_registration_no",
                    classX = "any_class_name",
                    section = "any_section"
                ),
                parent = StudentProfileDto.Profile.Parent(
                    father = "any_father_name",
                    mother = "any_mother_name",
                    contact = "any_contact",
                    occupation = "any_occupation"
                )
            )
        )
    }

    fun getStaffDto(): StaffProfileDto {
        return StaffProfileDto(
            profile = StaffProfileDto.Profile(
                username = "any_username",
                address = "any_address",
                avatar = "http://any_link",
                name = "any_name",
                bloodGroup = "O+|any",
                dob = "any_dob",
                gender = "any_gender",
                regNo = "any_regNo",
                contact = "any_contact",
                classX = "any_className",
                email = "any_email",
                department = "any_department",
                education = "any_education",
                subject = "any_subject"
            )
        )
    }
}