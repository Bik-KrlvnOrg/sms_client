package com.cheise_proj.student_app.di.module.data

import com.cheise_proj.data.repository.UserRepositoryImpl
import com.cheise_proj.domain.repository.UserRepository
import dagger.Binds
import dagger.Module

@Module(includes = [DataModule.Binders::class])
internal class DataModule {
    @Module
    internal interface Binders {
        @Binds
        fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
    }
}