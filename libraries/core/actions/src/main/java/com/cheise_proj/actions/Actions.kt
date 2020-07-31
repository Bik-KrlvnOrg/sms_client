package com.cheise_proj.actions

import android.content.Context
import android.net.Uri
import java.util.*
import javax.inject.Inject

interface Actions {
    fun navigate(context: Context, location: String): Uri
    fun navigate(context: Context, location: String, arg: String?): Uri
    fun navigate(context: Context, location: String, args1: String?, args2: String?): Uri
}

class ActionsImpl @Inject constructor() : Actions {

    override fun navigate(context: Context, location: String): Uri {
        val link =
            context.getString(R.string.deep_link_name, location.toLowerCase(Locale.getDefault()))
        return Uri.parse(link)
    }

    override fun navigate(context: Context, location: String, arg: String?): Uri {
        val link =
            context.getString(R.string.deep_link_name, location.toLowerCase(Locale.getDefault()))
        return Uri.parse("$link/$arg")
    }

    override fun navigate(context: Context, location: String, args1: String?, args2: String?): Uri {
        val link =
            context.getString(R.string.deep_link_name, location.toLowerCase(Locale.getDefault()))
        return Uri.parse("$link/$args1/$args2  ")
    }
}