package com.cheise_proj.dashboard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.cheise_proj.dashboard.BaseFragment
import com.cheise_proj.dashboard.R
import com.cheise_proj.dashboard.adapter.DashboardAdapter
import com.cheise_proj.dashboard.data.StudentMenu
import com.cheise_proj.dashboard.model.DashboardMenu
import com.cheise_proj.presentation.viewmodel.dashboard.DashboardVM
import kotlinx.android.synthetic.main.fragment_dashboard.*
import timber.log.Timber


/**
 * DashboardFragment subclass.
 */
class DashboardFragment : BaseFragment<DashboardVM>() {
    private val navArgs: DashboardFragmentArgs by navArgs()
    private lateinit var adapter: DashboardAdapter
    private val spanCount = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("user_type: ${navArgs.userType} user_id: ${navArgs.userId}")
        viewModel.setMenuItems(StudentMenu.getMenu(requireContext()))
        initRecyclerView()
        subscribeObserver()
    }

    private fun subscribeObserver() {
        viewModel.menuItems.observe(viewLifecycleOwner, Observer {
            @Suppress("UNCHECKED_CAST")
            adapter.submitList(it as List<DashboardMenu>)
            recycler_view.adapter = adapter
        })
    }

    private fun initRecyclerView() {
        adapter = DashboardAdapter() {
            Timber.i("menuClick: $it")
            findNavController().navigate(navigation.deepLink(it?.title))
        }
        recycler_view.apply {
            hasFixedSize()
            layoutManager = GridLayoutManager(context, spanCount)
        }
        recycler_view.adapter = adapter

    }

    override fun getViewModel(): Class<DashboardVM> = DashboardVM::class.java

}