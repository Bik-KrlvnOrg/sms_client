package com.cheise_proj.student_app.di.module.preference

import com.cheise_proj.presentation.preference.AppPreference
import com.cheise_proj.student_app.preference.AppPreferenceImpl
import com.cheise_proj.student_app.preference.PreferenceManager
import com.cheise_proj.student_app.preference.PreferenceManagerImpl
import dagger.Binds
import dagger.Module

@Module(includes = [PreferenceModule.Binders::class])
internal class PreferenceModule {
    @Module
    internal interface Binders {
        @Binds
        fun bindAppPreference(appPreferenceImpl: AppPreferenceImpl): AppPreference

        @Binds
        fun bindPreferenceManager(preferenceManagerImpl: PreferenceManagerImpl): PreferenceManager
    }
}