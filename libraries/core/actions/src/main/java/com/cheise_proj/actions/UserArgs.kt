package com.cheise_proj.actions

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

const val EXTRA_USER = "${APP_NAME}dashboard.extra_user"

@Parcelize
data class UserArgs(val userType: String?, val userId: Int?) : Parcelable