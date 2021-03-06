package com.cheise_proj.student_app.di.key

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)