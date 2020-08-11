package com.cheise_proj.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.cheise_proj.presentation.viewmodel.auth.ProfileVM
import com.cheise_proj.profile.BaseFragment
import com.cheise_proj.profile.R
import timber.log.Timber


/**
 * [ProfileFragment] subclass.
 */
class ProfileFragment : BaseFragment<ProfileVM>() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun getViewModel(): Class<ProfileVM> = ProfileVM::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.getProfile(preference.getUserSession().userId)
        viewModel.profile.observe(viewLifecycleOwner, Observer {
            Timber.i("view_profile: $it")
        })
    }

}