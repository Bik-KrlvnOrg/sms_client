package com.cheise_proj.data.source.local

import com.cheise_proj.data.model.User
import io.reactivex.rxjava3.core.Single

interface LocalUser {
    fun addUser(user: User)

    fun getUser(username: String, password: String, type: String): Single<User>
}