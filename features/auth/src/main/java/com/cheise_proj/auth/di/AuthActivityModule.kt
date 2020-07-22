package com.cheise_proj.auth.di

import com.cheise_proj.auth.AuthActivity
import dagger.android.ContributesAndroidInjector

interface AuthActivityModule {
    @ContributesAndroidInjector(modules = [AuthFragmentModule::class])
    fun contributeAuthActivity(): AuthActivity
}