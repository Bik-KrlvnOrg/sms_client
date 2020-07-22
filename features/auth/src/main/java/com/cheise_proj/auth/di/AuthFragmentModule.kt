package com.cheise_proj.auth.di

import com.cheise_proj.auth.ui.login.LoginFragment
import dagger.android.ContributesAndroidInjector

interface AuthFragmentModule {
    @ContributesAndroidInjector
    fun contributeLoginFragment(): LoginFragment

}