package com.cheise_proj.local_source.source

import com.cheise_proj.data.model.Profile
import com.cheise_proj.data.model.User
import com.cheise_proj.data.source.local.LocalUser
import com.cheise_proj.local_source.db.dao.UserDao
import com.cheise_proj.local_source.extension.asEntity
import com.cheise_proj.local_source.extension.asModel
import com.cheise_proj.local_source.model.UserEntity
import hu.akarnokd.rxjava3.bridge.RxJavaBridge
import io.reactivex.rxjava3.core.Single
import timber.log.Timber
import javax.inject.Inject

class LocalUserImpl @Inject constructor(private val userDao: UserDao) : LocalUser {
    override fun addUser(user: User) {
        Timber.i("addUser: $user")
        userDao.addUser(user.asEntity())
    }

    override fun getUser(username: String, password: String, type: String): Single<User> {
        return RxJavaBridge.toV3Single(userDao.getUser(username, password, type)
            .map {
                Timber.i("getUser:$it")
                it.asModel()
            })
    }

    override fun getUser(identifier: Int): Single<User> {
        return RxJavaBridge.toV3Single(userDao.getUser(identifier).map { t: UserEntity ->
            Timber.i("getUser:$t")
            t.asModel()
        })
    }

    override fun addProfile(profile: Profile) {
        Timber.i("addProfile: $profile")
       userDao.addProfile(profile.asEntity())
    }
}