package ru.vyaacheslav.suhov.imeit.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val localRepository = LocalRepository().getInstance()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
