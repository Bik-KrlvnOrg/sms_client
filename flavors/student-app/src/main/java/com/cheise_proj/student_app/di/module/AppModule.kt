package com.cheise_proj.student_app.di.module

import android.app.Application
import android.content.Context
import com.cheise_proj.student_app.di.module.data.DataModule
import com.cheise_proj.student_app.di.module.domain.DomainModule
import com.cheise_proj.student_app.di.module.local_source.LocalModule
import com.cheise_proj.student_app.di.module.presentation.PresentationModule
import com.cheise_proj.student_app.di.module.remote_source.RemoteModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        DomainModule::class,
        DataModule::class,
        PresentationModule::class,
        RemoteModule::class,
        LocalModule::class
    ]
)
internal class AppModule {

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}