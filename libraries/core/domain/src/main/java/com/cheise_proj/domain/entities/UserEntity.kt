package com.cheise_proj.domain.entities

data class UserEntity(
    val id: Int,
    var username: String,
    var avatarUrl: String,
    val schoolId: Int,
    val type: UserType
)

enum class UserType {
    ADMIN, STAFF, STUDENT
}