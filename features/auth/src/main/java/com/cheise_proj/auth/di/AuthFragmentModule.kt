package com.cheise_proj.auth.di

import com.cheise_proj.auth.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AuthFragmentModule {
    @ContributesAndroidInjector
    fun contributeLoginFragment(): LoginFragment

}