package com.cheise_proj.student_app.di.module.rxjava

import dagger.Binds
import dagger.Module

@Module
interface RxModule {
    @Binds
    fun provideRxSchedulers(rxSchedulersImpl: RxSchedulersImpl): RxSchedulers
}