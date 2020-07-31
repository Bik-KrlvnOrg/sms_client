package com.cheise_proj.dashboard.data

import android.content.Context
import com.cheise_proj.dashboard.R
import com.cheise_proj.dashboard.model.DashboardMenu

object StudentMenu : UserMenu() {
    override fun getMenu(context: Context): List<DashboardMenu> {
        return arrayListOf(
            DashboardMenu(
                "Profile",
                context.resources.getDrawable(R.drawable.ic_profile, context.theme)
            ),
            DashboardMenu(
                "Fees",
                context.resources.getDrawable(R.drawable.ic_fee, context.theme)
            ),
            DashboardMenu(
                "Homework",
                context.resources.getDrawable(R.drawable.ic_homework, context.theme)
            ),
            DashboardMenu(
                "Attendance",
                context.resources.getDrawable(R.drawable.ic_attendance, context.theme)
            ),
            DashboardMenu(
                "NoticeBoard",
                context.resources.getDrawable(R.drawable.ic_noticeboard, context.theme)
            ),
            DashboardMenu(
                "Teacher",
                context.resources.getDrawable(R.drawable.ic_presentation, context.theme)
            ), DashboardMenu(
                "Examination",
                context.resources.getDrawable(R.drawable.ic_test, context.theme)
            ), DashboardMenu(
                "Library",
                context.resources.getDrawable(R.drawable.ic_library, context.theme)
            ), DashboardMenu(
                "Transport",
                context.resources.getDrawable(R.drawable.ic_bus, context.theme)
            )
        )
    }
}