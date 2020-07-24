package com.cheise_proj.student_app.di.module.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cheise_proj.presentation.factory.ViewModelFactory
import com.cheise_proj.presentation.viewmodel.auth.AuthenticationVM
import com.cheise_proj.student_app.di.key.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [PresentationModule.Binders::class])
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

    }
}