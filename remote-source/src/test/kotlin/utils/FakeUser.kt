package utils

import com.cheise_proj.remote_source.model.LoginDto

object FakeUser {
    fun getLoginDto(): LoginDto {
        return LoginDto(
            accessToken = "any_access_token",
            refreshToken = "any_refresh_token"
        )
    }
}