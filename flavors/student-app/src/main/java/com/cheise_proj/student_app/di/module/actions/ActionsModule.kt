package com.cheise_proj.student_app.di.module.actions

import com.cheise_proj.actions.Actions
import com.cheise_proj.actions.ActionsImpl
import dagger.Binds
import dagger.Module

@Module
interface ActionsModule {
    @Binds
    fun bindActions(actionsImpl: ActionsImpl): Actions
}