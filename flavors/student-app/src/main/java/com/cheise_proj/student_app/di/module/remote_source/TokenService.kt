package com.cheise_proj.student_app.di.module.remote_source

import com.cheise_proj.local_source.db.dao.UserDao
import com.cheise_proj.presentation.preference.AppPreference
import com.cheise_proj.student_app.di.module.rxjava.RxSchedulers
import hu.akarnokd.rxjava3.bridge.RxJavaBridge
import io.reactivex.disposables.CompositeDisposable
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenService @Inject constructor(
    private val userDao: UserDao,
    private val preference: AppPreference,
    private val schedulers: RxSchedulers
) : Interceptor {
    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    private val disposable = CompositeDisposable()

    private fun getAccessToken(): String {
        var token: String = ""

        val status = preference.getLoggedInStatus()
        if (!status) return token
        val session = preference.getUserSession()

        disposable.add(userDao.getUser(session.userId)
            .doOnSuccess { token = "Bearer ${it.accessToken}" }
            .doOnError { Timber.e(it) }
            .observeOn(RxJavaBridge.toV2Scheduler(schedulers.provideAndroidSchedulers()))
            .subscribe({},{Timber.e(it,"TokenInterceptor.getAccessToken")}))
        return token
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val token = getAccessToken()
        Timber.i("token: $token")
        request = request.newBuilder().addHeader(AUTHORIZATION_HEADER, token).build()
        return chain.proceed(request)
    }

}