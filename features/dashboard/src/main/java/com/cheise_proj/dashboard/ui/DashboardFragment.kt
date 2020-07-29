package com.cheise_proj.dashboard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.cheise_proj.dashboard.R
import com.cheise_proj.dashboard.adapter.DashboardAdapter
import com.cheise_proj.dashboard.data.StudentMenu
import kotlinx.android.synthetic.main.fragment_dashboard.*
import timber.log.Timber


/**
 * DashboardFragment subclass.
 */
class DashboardFragment : Fragment() {

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
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = DashboardAdapter()
        adapter.submitList(StudentMenu.getMenu(requireContext()))
        recycler_view.apply {
            hasFixedSize()
            layoutManager = GridLayoutManager(context, spanCount)
        }
        recycler_view.adapter = adapter

    }

}