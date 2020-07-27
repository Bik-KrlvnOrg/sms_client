package com.cheise_proj.student_app.di.module.remote_source

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

internal object Logger {
    fun remoteLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.tag("API-SERVICE").i(message)
            }
        }).setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

}