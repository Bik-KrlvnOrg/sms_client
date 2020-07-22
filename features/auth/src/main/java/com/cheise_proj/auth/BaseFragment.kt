package com.cheise_proj.auth

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment

abstract class BaseFragment<VM : ViewModel> : DaggerFragment() {
    protected lateinit var viewModel: VM

    abstract fun getViewModel(): Class<VM>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[getViewModel()]
    }

}