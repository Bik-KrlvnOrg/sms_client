package com.cheise_proj.remote_source.model

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String
)