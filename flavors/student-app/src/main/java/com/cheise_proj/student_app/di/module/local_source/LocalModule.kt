package com.cheise_proj.student_app.di.module.local_source

import android.content.Context
import com.cheise_proj.data.source.local.LocalUser
import com.cheise_proj.local_source.db.AppDatabase
import com.cheise_proj.local_source.source.LocalUserImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [LocalModule.Binders::class, DaoModule::class])
internal class LocalModule {
    @Module
    internal interface Binders {
        //        USER
        @Binds
        fun bindLocalUser(localUserImpl: LocalUserImpl): LocalUser
    }


    //    APP DATABASE
    @Singleton
    @Provides
    internal fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getSInstance(context)
    }
}