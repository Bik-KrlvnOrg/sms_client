package com.cheise_proj.dashboard.di

import com.cheise_proj.dashboard.ui.DashboardFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DashboardFragmentModule {
    @ContributesAndroidInjector
    fun contributeDashboardFragment(): DashboardFragment
}