package com.cheise_proj.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val disposable: CompositeDisposable = CompositeDisposable()
    protected val _isSuccess:MutableLiveData<Boolean> = MutableLiveData(false)

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}