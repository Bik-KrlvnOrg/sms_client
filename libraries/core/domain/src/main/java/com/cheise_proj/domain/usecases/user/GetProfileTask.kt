package com.cheise_proj.domain.usecases.user

import com.cheise_proj.domain.entities.ProfileEntity
import com.cheise_proj.domain.qualifiers.Background
import com.cheise_proj.domain.repository.UserRepository
import com.cheise_proj.domain.rx.ObservableUseCase
import com.cheise_proj.domain.rx.qualifier.Foreground
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

class GetProfileTask @Inject constructor(
    private val userRepository: UserRepository,
    @Background backgroundScheduler: Scheduler,
    @Foreground foregroundScheduler: Scheduler
) :
    ObservableUseCase<ProfileEntity, GetProfileTask.Params>(
        backgroundScheduler,
        foregroundScheduler
    ) {

    data class Params (
        var userId: Int = -1
   )

    override fun generateObservable(input: Params): Observable<ProfileEntity> {
        return userRepository.getProfile(input.userId)
    }
}