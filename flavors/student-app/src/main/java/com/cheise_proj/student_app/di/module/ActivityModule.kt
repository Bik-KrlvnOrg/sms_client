package com.cheise_proj.student_app.di.module

import com.cheise_proj.auth.di.AuthFragmentModule
import com.cheise_proj.dashboard.di.DashboardFragmentModule
import com.cheise_proj.profile.module.ProfileFragmentModule
import com.cheise_proj.student_app.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface ActivityModule {
    @ContributesAndroidInjector(
        modules = [
            AuthFragmentModule::class,
            DashboardFragmentModule::class,
            ProfileFragmentModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}