package com.cheise_proj.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cheise_proj.presentation.viewmodel.auth.ProfileVM
import com.cheise_proj.profile.BaseFragment
import com.cheise_proj.profile.R
import com.cheise_proj.profile.adapter.ProfileAdapter
import com.cheise_proj.profile.extension.serializeToMap
import com.cheise_proj.profile.model.Profile
import kotlinx.android.synthetic.main.fragment_profile.*
import timber.log.Timber


/**
 * [ProfileFragment] subclass.
 */
class ProfileFragment : BaseFragment<ProfileVM>() {

    private lateinit var adapter: ProfileAdapter
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
        initRecyclerView()
        subscribeObservers()
    }

    private fun initRecyclerView() {
        adapter = ProfileAdapter()
        recycler_view.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        recycler_view.adapter = adapter
    }

    private fun subscribeObservers() {
        viewModel.getProfile(preference.getUserSession().userId)
        viewModel.profile.observe(viewLifecycleOwner, Observer {
            setUserAvatar(it.avatar)
            val profileList = getProfileToList(it)
            adapter.submitList(profileList)
            recycler_view.adapter = adapter
        })
    }

    private fun setUserAvatar(avatar: String) {
        // TODO fix avatar url at server level
        Timber.w("avatar-image not set yet")
    }

    private fun getProfileToList(it: com.cheise_proj.presentation.model.Profile?): ArrayList<Profile> {
        Timber.i("view_profile: $it")
        val mapProfile = it.serializeToMap().toMutableMap()
        Timber.i("profile-map: $mapProfile")
        mapProfile.remove("avatar")
        mapProfile.remove("id")
        mapProfile.remove("userId")
        val profile = arrayListOf<Profile>()
        for (data in mapProfile) {
            profile.add(Profile(data.key, data.value.toString()))
        }
        Timber.i("profile-array: $profile")
        return profile
    }

}