package com.cheise_proj.actions

import android.content.Context
import android.content.Intent
import android.net.Uri

object Actions {
    fun openDashboard(context: Context, user: UserArgs? = null): Uri {
        val link = context.getString(R.string.deep_link_name, "dashboard")
        return Uri.parse("$link/${user?.userType}/${user?.userId}")
    }

    fun openAuthIntent(context: Context): Intent {
        val action = context.getString(R.string.action_name, "auth")
        return internalIntent(context, action)
    }

    private fun internalIntent(context: Context, action: String): Intent {
        return Intent(action).setPackage(context.packageName)
    }
}