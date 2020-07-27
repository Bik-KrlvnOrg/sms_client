package com.cheise_proj.student_app.di.module

import com.cheise_proj.student_app.di.module.auth_feature.AuthFeatureModule
import dagger.Module

@Module(includes = [AuthFeatureModule::class])
internal interface ActivityModule