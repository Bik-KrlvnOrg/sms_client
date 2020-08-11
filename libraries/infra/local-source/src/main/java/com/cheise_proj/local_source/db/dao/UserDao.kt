package com.cheise_proj.local_source.db.dao

import androidx.room.*
import com.cheise_proj.local_source.model.ProfileEntity
import com.cheise_proj.local_source.model.UserEntity
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun newUser(user: UserEntity)

    @Query("DELETE FROM users")
    fun removeUser()

    @Transaction
    fun addUser(user: UserEntity) {
        removeUser()
        newUser(user)
    }

    @Query("SELECT * FROM users WHERE username = :username AND password = :password AND type = :type")
    fun getUser(username: String, password: String, type: String): Single<UserEntity>

    @Query("SELECT * FROM users WHERE id = :identifier")
    fun getUser(identifier: Int): Single<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun newProfile(profile: ProfileEntity)

    @Query("DELETE FROM profile")
    fun removeProfile()

    @Transaction
    fun addProfile(profile: ProfileEntity) {
        removeProfile()
        newProfile(profile)
    }

    @Query("SELECT * FROM profile WHERE userId = :identifier")
    fun getProfile(identifier: Int):Single<ProfileEntity>
}