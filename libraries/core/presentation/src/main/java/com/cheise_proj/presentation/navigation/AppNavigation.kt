package com.cheise_proj.presentation.navigation

import android.net.Uri

interface AppNavigation {

    fun deepLink(location: String?): Uri
    fun deepLink(location: String?, arg: String? =null): Uri
    fun deepLink(location: String?, args1: String?=null, args2: String?=null): Uri

}