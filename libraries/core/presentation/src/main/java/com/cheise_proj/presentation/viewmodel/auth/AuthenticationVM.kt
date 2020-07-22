package com.cheise_proj.presentation.viewmodel.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.toLiveData


import com.cheise_proj.domain.entities.UserType

import com.cheise_proj.domain.usecases.user.AuthenticationTask
import com.cheise_proj.presentation.R
import com.cheise_proj.presentation.extensions.toModel
import com.cheise_proj.presentation.model.Resource
import com.cheise_proj.presentation.model.Status
import com.cheise_proj.presentation.model.User
import com.cheise_proj.presentation.viewmodel.BaseViewModel
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

open class AuthenticationVM @Inject constructor(private val authenticationTask: AuthenticationTask) :
    BaseViewModel() {
    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm
    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult
    var userResource: LiveData<Resource<User>> = MutableLiveData()

    fun authenticateWithCredentials(username: String, password: String, type: UserType) {
        userResource =
            authenticationTask.execute(AuthenticationTask.Params(username, password, type.name))
                .map { it.toModel() }
                .map { Resource.success(it) }
                .startWith(Observable.just(Resource.loading()))
                .onErrorResumeNext { Observable.just(Resource.error(it.localizedMessage)) }
                .toFlowable(BackpressureStrategy.LATEST).toLiveData()
    }


    fun login(username: String, password: String, type: String) {
        disposable.add(authenticationTask.execute(
            AuthenticationTask.Params(
                username,
                password,
                type
            )
        )
            .map { it.toModel() }
            .map { Resource.success(it) }
            .startWith(Observable.just(Resource.loading()))
            .onErrorResumeNext { Observable.just(Resource.error(it.localizedMessage)) }
            .subscribe({
                loadResult(it)
            }, {
                _loginResult.value = LoginResult(error = R.string.login_failed)
            })
        )

    }

    fun loginDataChanged(username: String, password: String, type: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else if (!isUserTypeValid(type)) {
            _loginForm.value = LoginFormState(userTypeError = R.string.invalid_user_type)

        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    private fun loadResult(it: Resource<User>?) {
        if (it?.status == Status.SUCCESS) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = it.data?.username))
        }
    }

    private fun isUserTypeValid(type: String): Boolean {
        return type.isNotBlank()
    }

    private fun isUserNameValid(username: String): Boolean {
        return username.isNotBlank()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 4
    }


}

