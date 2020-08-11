package com.cheise_proj.profile.module

import com.cheise_proj.profile.ui.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ProfileFragmentModule {
    @ContributesAndroidInjector
    fun contributeProfileFragment(): ProfileFragment
}