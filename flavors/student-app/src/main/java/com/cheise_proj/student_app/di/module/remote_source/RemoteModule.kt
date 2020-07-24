package com.cheise_proj.student_app.di.module.remote_source

import com.cheise_proj.data.source.remote.RemoteUser
import com.cheise_proj.remote_source.service.ApiService
import com.cheise_proj.remote_source.source.RemoteUserImpl
import com.cheise_proj.student_app.BuildConfig
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [RemoteModule.Binders::class])
internal class RemoteModule {
    companion object {
        private const val WRITE_TIMEOUT: Long = 10
        private const val READ_TIMEOUT: Long = 10
        private const val CALL_TIMEOUT: Long = 10
        private const val CONNECT_TIMEOUT: Long = 10
    }

    @Module
    internal interface Binders {
        //        USER SERVICE
        @Binds
        fun bindRemoteUser(remoteUserImpl: RemoteUserImpl): RemoteUser
    }

    //    OK HTTP CLIENT
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .callTimeout(CALL_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(Logger.remoteLogging())
            .build()
    }

    @Provides
    fun provideGson(): Gson {
        return Gson().newBuilder()
            .create()
    }

    //    RETROFIT
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }


    //    API SERVICE
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}