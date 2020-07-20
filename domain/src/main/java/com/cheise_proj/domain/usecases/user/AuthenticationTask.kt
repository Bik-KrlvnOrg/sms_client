package com.cheise_proj.domain.usecases.user

import com.cheise_proj.domain.entities.UserEntity
import com.cheise_proj.domain.qualifiers.Background
import com.cheise_proj.domain.repository.UserRepository
import com.cheise_proj.domain.rx.ObservableUseCase
import com.cheise_proj.domain.rx.qualifier.Foreground
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

class AuthenticationTask @Inject constructor(
    private val userRepository: UserRepository,
    @Background backgroundScheduler: Scheduler,
    @Foreground foregroundScheduler: Scheduler
) :
    ObservableUseCase<UserEntity, AuthenticationTask.Params>(
        backgroundScheduler,
        foregroundScheduler
    ) {

    override fun generateObservable(input: Params): Observable<UserEntity> {
        if (input.username.isEmpty()) throw IllegalArgumentException("provide a username")
        if (input.password.isEmpty()) throw IllegalArgumentException("provide a password")

        return with(input) {
            userRepository.getUser(username, password,type)
        }

    }

    data class Params(
        val username: String,
        val password: String,
        val type:String
    )
}
