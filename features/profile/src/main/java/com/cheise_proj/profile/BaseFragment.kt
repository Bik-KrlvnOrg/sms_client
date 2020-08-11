package com.cheise_proj.profile

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cheise_proj.presentation.factory.ViewModelFactory
import com.cheise_proj.presentation.navigation.AppNavigation
import com.cheise_proj.presentation.preference.AppPreference
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel> : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var navigation: AppNavigation

    @Inject lateinit var preference: AppPreference

    protected lateinit var viewModel: VM

    abstract fun getViewModel(): Class<VM>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[getViewModel()]
    }

}