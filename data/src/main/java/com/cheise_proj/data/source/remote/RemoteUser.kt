package com.cheise_proj.data.source.remote

import com.cheise_proj.data.model.User
import io.reactivex.rxjava3.core.Observable

interface RemoteUser {

    fun fetchUser(username: String, password: String): Observable<User>

}