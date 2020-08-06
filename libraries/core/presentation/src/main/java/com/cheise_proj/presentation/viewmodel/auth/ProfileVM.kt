package com.cheise_proj.presentation.viewmodel.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cheise_proj.domain.entities.ProfileEntity
import com.cheise_proj.domain.usecases.user.GetProfileTask
import com.cheise_proj.presentation.extensions.asModel
import com.cheise_proj.presentation.model.Profile
import com.cheise_proj.presentation.model.Resource
import com.cheise_proj.presentation.model.Status
import com.cheise_proj.presentation.viewmodel.BaseViewModel
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber
import javax.inject.Inject

class ProfileVM @Inject constructor(private val getProfileTask: GetProfileTask) :
    BaseViewModel() {
    private val _profile: MutableLiveData<Profile> = MutableLiveData()
    val profile: LiveData<Profile> = _profile

    fun getProfile(userId: Int) {
        disposable.add(getProfileTask.execute(GetProfileTask.Params(userId))
            .map { t: ProfileEntity ->
                t.asModel()
            }
            .map {
                Resource.success(it)
            }
            .startWith(Observable.just(Resource.loading()))
            .onErrorResumeNext { Observable.just(Resource.error(it.localizedMessage)) }
            .subscribe({
                Timber.i("profile: $it")
                loadProfile(it)

            }, { t: Throwable ->
                Timber.e(t, "getProfileError")
            })
        )
    }

    private fun loadProfile(res: Resource<Profile>) {
        if (res.status == Status.SUCCESS) {
            _profile.postValue(res.data)
            _isSuccess.postValue(true)
            return
        }
        _isSuccess.postValue(false)
    }
}