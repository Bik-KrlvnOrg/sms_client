package com.cheise_proj.dashboard.data

import android.content.Context
import com.cheise_proj.dashboard.model.DashboardMenu

abstract class UserMenu {
    abstract fun getMenu(context: Context): List<DashboardMenu>
}