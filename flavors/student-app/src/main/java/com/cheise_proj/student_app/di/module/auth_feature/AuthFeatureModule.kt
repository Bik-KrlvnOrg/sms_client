package com.cheise_proj.student_app.di.module.auth_feature

import com.cheise_proj.auth.AuthActivity
import com.cheise_proj.auth.di.AuthFragmentModule
import com.cheise_proj.auth.di.scope.AuthFeatureScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface AuthFeatureModule {
    @AuthFeatureScope
    @ContributesAndroidInjector(modules = [AuthFragmentModule::class])
    fun contributeAuthActivity(): AuthActivity
}