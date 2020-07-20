package com.cheise_proj.data.source.remote

import com.cheise_proj.data.model.User
import io.reactivex.rxjava3.core.Observable

interface RemoteUser {

    fun fetchUserToken(username: String, password: String, type:String): Observable<User>

}