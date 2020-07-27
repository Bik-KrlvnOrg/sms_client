package com.cheise_proj.actions

import android.content.Context
import android.content.Intent

object Actions {
    fun openDashboardIntent(context: Context, user:UserArgs): Intent {
        val action = context.getString(R.string.action_name,"dashboard")
        return internalIntent(context, action).putExtra(EXTRA_USER, user)
    }

    fun openAuthIntent(context: Context): Intent {
//        val action = context.getString(R.string.action_name,"auth")
        val action = "com.cheise_proj.auth.open"
        return internalIntent(context, action)
    }

    private fun internalIntent(context: Context, action: String): Intent {
        return Intent(action).setPackage(context.packageName)
    }
}