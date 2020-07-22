package com.cheise_proj.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<VM : ViewModel> : Fragment() {
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