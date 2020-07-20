package com.cheise_proj.local_source.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val username: String,
    val password: String,
    val type: String,
    val schoolId: Int,
    val avatarUrl: String,
    val accessToken: String,
    val refreshToken: String
)