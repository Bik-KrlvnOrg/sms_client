package com.cheise_proj.dashboard

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cheise_proj.presentation.factory.ViewModelFactory
import com.cheise_proj.presentation.navigation.AppNavigation
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel> : DaggerFragment() {
    @Inject
    lateinit var navigation: AppNavigation

    @Inject
    lateinit var factory: ViewModelFactory

    protected lateinit var viewModel: VM

    abstract fun getViewModel(): Class<VM>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[getViewModel()]
    }
}