package com.cheise_proj.remote_source.model


import com.google.gson.annotations.SerializedName

data class StudentProfileDto(
    @SerializedName("profile")
    val profile: Profile
) {
    data class Profile(
        @SerializedName("parent")
        val parent: Parent,
        @SerializedName("personal")
        val personal: Personal
    ) {
        data class Parent(
            @SerializedName("contact")
            val contact: String,
            @SerializedName("father")
            val father: String,
            @SerializedName("mother")
            val mother: String,
            @SerializedName("occupation")
            val occupation: String
        )

        data class Personal(
            @SerializedName("address")
            val address: String,
            @SerializedName("avatar")
            val avatar: String,
            @SerializedName("bloodGroup")
            val bloodGroup: String,
            @SerializedName("class")
            val classX: String,
            @SerializedName("dob")
            val dob: String,
            @SerializedName("gender")
            val gender: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("regNo")
            val regNo: String,
            @SerializedName("section")
            val section: String,
            @SerializedName("username")
            val username: String
        )
    }
}