package com.cheise_proj.student_app.di.module.navigation

import com.cheise_proj.presentation.navigation.AppNavigation
import com.cheise_proj.student_app.navigation.AppNavigationImpl
import dagger.Binds
import dagger.Module

@Module
interface AppNavigationModule {
    @Binds
    fun bindAppNavigation(appNavigationImpl: AppNavigationImpl): AppNavigation
}