package com.cheise_proj.student_app.di

import android.app.Application
import com.cheise_proj.student_app.StudentApp
import com.cheise_proj.student_app.di.module.ActivityModule
import com.cheise_proj.student_app.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityModule::class])
interface AppComponent : AndroidInjector<StudentApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(instance: StudentApp?)
}