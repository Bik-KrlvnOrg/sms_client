package com.cheise_proj.domain.usecases

import io.reactivex.rxjava3.core.Scheduler

abstract class BaseUseCase constructor(
    protected val backgroundScheduler: Scheduler,
    protected val foregroundScheduler: Scheduler
)