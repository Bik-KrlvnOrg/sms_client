package com.cheise_proj.student_app.navigation

import android.content.Context
import android.net.Uri
import com.cheise_proj.actions.Actions
import com.cheise_proj.presentation.navigation.AppNavigation
import javax.inject.Inject

class AppNavigationImpl @Inject constructor(private val context: Context,private val action:Actions) : AppNavigation {
    override fun deepLink(location: String?): Uri {
        if (location == null) throw IllegalArgumentException("location is required")
        return action.navigate(context, location)
    }

    override fun deepLink(location: String?, arg: String?): Uri {
        if (location == null) throw IllegalArgumentException("location is required")
        return action.navigate(context, location, arg)
    }

    override fun deepLink(location: String?, args1: String?, args2: String?): Uri {
        if (location == null) throw IllegalArgumentException("location is required")
        return action.navigate(context, location, args1, args2)
    }

}