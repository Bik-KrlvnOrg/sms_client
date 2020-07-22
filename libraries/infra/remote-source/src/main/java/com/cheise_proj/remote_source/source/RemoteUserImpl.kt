package com.cheise_proj.remote_source.source

import com.cheise_proj.data.model.User
import com.cheise_proj.data.source.remote.RemoteUser
import com.cheise_proj.remote_source.extension.toModel
import com.cheise_proj.remote_source.model.CredentialDto
import com.cheise_proj.remote_source.service.ApiService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RemoteUserImpl @Inject constructor(private val apiService: ApiService) : RemoteUser {
    override fun fetchUserToken(
        username: String,
        password: String,
        type: String
    ): Observable<User> {
        return apiService.loginUser(
            CredentialDto(
                username,
                password,
                type
            )
        )
            .map {
                it.toModel()
            }

    }
}