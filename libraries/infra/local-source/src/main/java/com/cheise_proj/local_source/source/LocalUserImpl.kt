package com.cheise_proj.local_source.source

import com.cheise_proj.data.model.User
import com.cheise_proj.data.source.local.LocalUser
import com.cheise_proj.local_source.db.dao.UserDao
import com.cheise_proj.local_source.extension.toModel
import com.cheise_proj.local_source.extension.toObject
import hu.akarnokd.rxjava3.bridge.RxJavaBridge
import io.reactivex.rxjava3.core.Single
import timber.log.Timber
import javax.inject.Inject

class LocalUserImpl @Inject constructor(private val userDao: UserDao) : LocalUser {
    override fun addUser(user: User) {
        Timber.i("addUser: $user")
        userDao.addUser(user.toObject())
    }

    override fun getUser(username: String, password: String, type: String): Single<User> {
        return RxJavaBridge.toV3Single(userDao.getUser(username, password, type)
            .map {
                Timber.i("getUser:$it")
                it.toModel()
            })
    }
}