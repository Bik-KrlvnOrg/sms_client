package com.cheise_proj.presentation.viewmodel.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cheise_proj.presentation.viewmodel.BaseViewModel
import javax.inject.Inject

class DashboardVM @Inject  constructor(): BaseViewModel() {
    private val _menuItems: MutableLiveData<List<*>> = MutableLiveData()
    val menuItems: LiveData<List<*>> = _menuItems

    fun setMenuItems(data: List<*>) {
        _menuItems.value = data
    }
}