package com.cheise_proj.data.repository

import com.cheise_proj.data.extension.asEntity
import com.cheise_proj.data.model.Profile
import com.cheise_proj.data.model.User
import com.cheise_proj.data.source.local.LocalUser
import com.cheise_proj.data.source.remote.RemoteUser
import com.cheise_proj.domain.entities.ProfileEntity
import com.cheise_proj.domain.entities.UserEntity
import com.cheise_proj.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Observable
import java.util.*
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remote: RemoteUser,
    private val local: LocalUser
) : UserRepository {

    override fun getUser(username: String, password: String, type: String): Observable<UserEntity> {
        val localUser = local.getUser(username = username, password = password, type = type)
            .map { t: User ->
                println("local data: $t")
                t.asEntity()
            }
            .toObservable()
        return remote.fetchUserToken(
            username = username, password = password,
            type = type.toLowerCase(Locale.ROOT)
        )
            .map { t: User ->
                t.username = username
                t.type = type
                t.password = password
                local.addUser(t)
                t.asEntity()
            }.onErrorResumeNext { Observable.empty() }
            .concatWith(localUser)
    }

    override fun getProfile(identifier: Int): Observable<ProfileEntity> {
        val localProfile = local.getProfile(identifier).toObservable().map { it.asEntity() }
        return local.getUser(identifier).toObservable()
            .flatMap { t: User ->
                println("local data: $t")

                remote.fetchProfile(t.type)
                    .map { profile: Profile ->
                        profile.userId = identifier
                        local.addProfile(profile)
                        profile.asEntity()
                    }
                    .onErrorResumeNext { Observable.empty() }
                    .concatWith(localProfile)
            }


    }
}