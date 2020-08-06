package com.cheise_proj.remote_source.model


import com.google.gson.annotations.SerializedName

class StaffProfileDto(
    @SerializedName("profile")
    val profile: Profile
) {
    data class Profile(
        @SerializedName("address")
        val address: String,
        @SerializedName("avatar")
        val avatar: String,
        @SerializedName("bloodGroup")
        val bloodGroup: String,
        @SerializedName("class")
        val classX: String,
        @SerializedName("contact")
        val contact: String,
        @SerializedName("department")
        val department: String,
        @SerializedName("dob")
        val dob: String,
        @SerializedName("education")
        val education: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("gender")
        val gender: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("regNo")
        val regNo: String,
        @SerializedName("subject")
        val subject: String,
        @SerializedName("username")
        val username: String
    )
}