package com.cheise_proj.student_app.preference

import android.content.SharedPreferences
import javax.inject.Inject

private const val DEFAULT_INTEGER = -1

interface PreferenceManager {
    fun putString(key: String, value: String?)
    fun putBoolean(key: String, value: Boolean)
    fun putInteger(key: String, value: Int)

    fun getString(key: String, default: String? = null): String?
    fun getBoolean(key: String, default: Boolean = false): Boolean
    fun getInt(key: String, default: Int = DEFAULT_INTEGER): Int

    fun clear()

}

class PreferenceManagerImpl @Inject constructor(private val preferences: SharedPreferences) :
    PreferenceManager {
    private fun getPrefEdit(): SharedPreferences.Editor {
        return preferences.edit()
    }

    override fun putString(key: String, value: String?) {
        getPrefEdit().putString(key, value).apply()
    }

    override fun putBoolean(key: String, value: Boolean) {
        getPrefEdit().putBoolean(key, value).apply()
    }

    override fun putInteger(key: String, value: Int) {
        getPrefEdit().putInt(key, value).apply()
    }

    override fun getString(key: String, default: String?): String? {
        return preferences.getString(key, default)
    }

    override fun getBoolean(key: String, default: Boolean): Boolean {
        return preferences.getBoolean(key, default)
    }

    override fun getInt(key: String, default: Int): Int {
        return preferences.getInt(key, default)
    }

    override fun clear() {
        getPrefEdit().clear().apply()
    }


}