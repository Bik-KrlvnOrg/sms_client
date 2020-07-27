package com.cheise_proj.data.repository

import com.cheise_proj.data.extension.asObject
import com.cheise_proj.data.model.User
import com.cheise_proj.data.source.local.LocalUser
import com.cheise_proj.data.source.remote.RemoteUser
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
        val localUser = local.getUser(username = username, password = password,type = type)
            .map { t: User ->
                println("local data: $t")
                t.asObject()
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
                t.asObject()
            }.onErrorResumeNext { Observable.empty() }
            .concatWith(localUser)
    }
}