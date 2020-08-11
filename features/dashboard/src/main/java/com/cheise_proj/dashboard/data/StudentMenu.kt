package com.cheise_proj.dashboard.data

import android.content.Context
import com.cheise_proj.dashboard.R
import com.cheise_proj.dashboard.model.DashboardMenu

object StudentMenu : UserMenu() {
    override fun getMenu(context: Context): List<DashboardMenu> {
        return arrayListOf(
            DashboardMenu(
                title = "Profile",
                image = context.resources.getDrawable(R.drawable.ic_profile, context.theme),
                deepLink = "profile"
            ),
            DashboardMenu(
                title = "Fees",
                image = context.resources.getDrawable(R.drawable.ic_fee, context.theme),
                deepLink = ""

            ),
            DashboardMenu(
                title = "Homework",
                image = context.resources.getDrawable(R.drawable.ic_homework, context.theme),
                deepLink = ""
            ),
            DashboardMenu(
                title = "Attendance",
                image = context.resources.getDrawable(R.drawable.ic_attendance, context.theme),
                deepLink = ""
            ),
            DashboardMenu(
                title = "NoticeBoard",
                image = context.resources.getDrawable(R.drawable.ic_noticeboard, context.theme),
                deepLink = ""
            ),
            DashboardMenu(
                title = "Teacher",
                image = context.resources.getDrawable(R.drawable.ic_presentation, context.theme),
                deepLink = ""
            ), DashboardMenu(
                title = "Examination",
                image = context.resources.getDrawable(R.drawable.ic_test, context.theme),
                deepLink = ""
            ), DashboardMenu(
                title = "Library",
                image = context.resources.getDrawable(R.drawable.ic_library, context.theme),
                deepLink = ""
            ), DashboardMenu(
                title = "Transport",
                image = context.resources.getDrawable(R.drawable.ic_bus, context.theme),
                deepLink = ""

            )
        )
    }
}