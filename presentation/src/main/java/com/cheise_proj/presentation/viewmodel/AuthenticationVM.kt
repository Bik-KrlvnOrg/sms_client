package com.cheise_proj.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.toLiveData
import com.cheise_proj.domain.entities.UserType
import com.cheise_proj.domain.usecases.user.AuthenticationTask
import com.cheise_proj.presentation.extensions.toModel
import com.cheise_proj.presentation.model.Resource
import com.cheise_proj.presentation.model.User
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class AuthenticationVM @Inject constructor(private val authenticationTask: AuthenticationTask) :
    BaseViewModel() {

    var userResource: LiveData<Resource<User>> = MutableLiveData()

    fun authenticateWithCredentials(username: String, password: String,type:UserType) {
        userResource =
            authenticationTask.execute(AuthenticationTask.Params(username, password,type.name))
                .map { it.toModel() }
                .map { Resource.success(it) }
                .startWith(Observable.just(Resource.loading()))
                .onErrorResumeNext { Observable.just(Resource.error(it.localizedMessage)) }
                .toFlowable(BackpressureStrategy.LATEST).toLiveData()
    }


}

