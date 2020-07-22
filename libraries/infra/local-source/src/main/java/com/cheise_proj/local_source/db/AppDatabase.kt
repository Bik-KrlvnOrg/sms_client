package com.cheise_proj.local_source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cheise_proj.local_source.db.dao.UserDao
import com.cheise_proj.local_source.model.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}