package com.cheise_proj.student_app.preference

import android.content.Context
import com.cheise_proj.presentation.model.UserSession
import com.cheise_proj.presentation.preference.AppPreference
import com.cheise_proj.student_app.R
import timber.log.Timber
import javax.inject.Inject

class AppPreferenceImpl @Inject constructor(
    private val context: Context,
    private val preference: PreferenceManager
) : AppPreference {
    override fun setLoggedInStatus(status: Boolean) {
        Timber.i("setLoggedInStatus: $status")
        preference.putBoolean(context.getString(R.string.pref_key_logged_in_status), status)
    }

    override fun setLogOut() {
        Timber.i("setLogOut")
        preference.clear()
        showOnBoardingScreen(status = false)
    }

    override fun showOnBoardingScreen(status: Boolean) {
        Timber.i("showOnBoardingScreen: $status")
        preference.putBoolean(context.getString(R.string.pref_key_on_boarding_status), status)
    }

    override fun setUserSession(user: UserSession) {
        Timber.i("setUserSession: $user")
        with(user) {
            preference.putInteger(context.getString(R.string.pref_key_user_id), userId)
            preference.putString(context.getString(R.string.pref_key_display_name), displayName)
            preference.putString(context.getString(R.string.pref_key_school_id), schoolId)
            preference.putString(context.getString(R.string.pref_key_user_type), userType)
        }
    }

    override fun getLoggedInStatus(): Boolean {
        val result = preference.getBoolean(context.getString(R.string.pref_key_logged_in_status))
        Timber.i("getLoggedInStatus: $result")
        return result
    }

    override fun getOnBoardingStatus(): Boolean {
        val result =
            preference.getBoolean(context.getString(R.string.pref_key_on_boarding_status))
        Timber.i("getOnBoardingStatus: $result")
        return result
    }

    override fun getUserSession(): UserSession {
        val result = UserSession(
            userId = preference.getInt(context.getString(R.string.pref_key_user_id)),
            displayName = preference.getString(context.getString(R.string.pref_key_display_name)),
            schoolId = preference.getString(context.getString(R.string.pref_key_school_id)),
            userType = preference.getString(context.getString(R.string.pref_key_user_type))
        )
        Timber.i("getUserSession: $result")
        return result
    }
}