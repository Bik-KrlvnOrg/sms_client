package com.cheise_proj.student_app.di.module.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cheise_proj.presentation.factory.ViewModelFactory
import com.cheise_proj.presentation.viewmodel.auth.AuthenticationVM
import com.cheise_proj.presentation.viewmodel.auth.ProfileVM
import com.cheise_proj.presentation.viewmodel.dashboard.DashboardVM
import com.cheise_proj.student_app.di.key.ViewModelKey
import com.cheise_proj.student_app.di.module.preference.PreferenceModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [PresentationModule.Binders::class, PreferenceModule::class])
internal class PresentationModule {
    @Module
    internal interface Binders {
        //        VIEW MODEL FACTORY
        @Binds
        fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

        //        Authentication VM
        @Binds
        @IntoMap
        @ViewModelKey(AuthenticationVM::class)
        fun bindAuthenticationVM(authenticationVM: AuthenticationVM): ViewModel

        //        DASHBOARD VM

        @Binds
        @IntoMap
        @ViewModelKey(DashboardVM::class)
        fun bindDashboardVM(dashboardVM: DashboardVM): ViewModel

        //        PROFILE VM

        @Binds
        @IntoMap
        @ViewModelKey(ProfileVM::class)
        fun bindProfileVM(profileVM: ProfileVM): ViewModel
    }
}