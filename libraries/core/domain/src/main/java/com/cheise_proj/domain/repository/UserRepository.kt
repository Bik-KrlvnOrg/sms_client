package com.cheise_proj.domain.repository

import com.cheise_proj.domain.entities.UserEntity
import io.reactivex.rxjava3.core.Observable

interface UserRepository {

    fun getUser(username: String, password: String, type: String): Observable<UserEntity>
}