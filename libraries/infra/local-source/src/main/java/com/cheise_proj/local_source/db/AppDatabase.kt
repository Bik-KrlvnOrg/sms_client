package com.cheise_proj.local_source.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cheise_proj.local_source.db.dao.UserDao
import com.cheise_proj.local_source.model.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private const val DATABASE_NAME = "sms_cache.db"

        fun getSInstance(context: Context): AppDatabase =
            INSTANCE ?: INSTANCE ?: buildDataBase(context)
                .also { appDatabase: AppDatabase -> INSTANCE = appDatabase }


        private fun buildDataBase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }

    }
}