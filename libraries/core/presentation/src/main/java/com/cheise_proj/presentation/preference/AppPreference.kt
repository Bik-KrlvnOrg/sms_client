package com.cheise_proj.presentation.preference

import com.cheise_proj.presentation.model.UserSession

interface AppPreference {
    fun setLoggedInStatus(status: Boolean)

    fun setLogOut()

    fun showOnBoardingScreen(status: Boolean)

    fun setUserSession(user: UserSession)

    fun getLoggedInStatus(): Boolean

    fun getOnBoardingStatus(): Boolean

    fun getUserSession(): UserSession
}