package com.cheise_proj.student_app.di.module.local_source

import com.cheise_proj.local_source.db.AppDatabase
import com.cheise_proj.local_source.db.dao.UserDao
import dagger.Module
import dagger.Provides

@Module
internal class DaoModule {
    //    USER
    @Provides
    fun bindUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()
}