package com.cheise_proj.local_source.db.dao

import androidx.room.*
import com.cheise_proj.local_source.model.UserEntity
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun newUser(user: UserEntity)

    @Query("DELETE FROM users")
    fun remoteUser()

    @Transaction
    fun addUser(user: UserEntity) {
        remoteUser()
        newUser(user)
    }

    @Query("SELECT * FROM users WHERE username = :username AND password = :password AND type = :type")
    fun getUser(username: String, password: String, type: String): Single<UserEntity>
}