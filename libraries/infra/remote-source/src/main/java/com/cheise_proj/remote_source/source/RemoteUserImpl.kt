package com.cheise_proj.remote_source.source

import com.cheise_proj.data.model.Profile
import com.cheise_proj.data.model.User
import com.cheise_proj.data.source.remote.RemoteUser
import com.cheise_proj.remote_source.USERTYPE
import com.cheise_proj.remote_source.extension.asModel
import com.cheise_proj.remote_source.extension.toModel
import com.cheise_proj.remote_source.model.CredentialDto
import com.cheise_proj.remote_source.model.StaffProfileDto
import com.cheise_proj.remote_source.model.StudentProfileDto
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
                println("RemoteUserImpl.fetchUserToken: $it")
                it.toModel()
            }

    }

    override fun fetchProfile(userType: String): Observable<Profile> {
        return when (USERTYPE.valueOf(userType)) {
            USERTYPE.STUDENT -> apiService.getStudentProfile()
                .map { t: StudentProfileDto ->
                    println("RemoteUserImpl.fetchProfile: userType: $userType: $t")
                    t.asModel()
                }
            USERTYPE.ADMIN -> TODO("ADMIN NOT IMPLEMENTED YET")

            USERTYPE.STAFF -> apiService.getStaffProfile().map { t: StaffProfileDto ->
                println("RemoteUserImpl.fetchProfile: userType: $userType: $t")
                t.asModel()
            }
        }
    }
}