package ru.suhov.student.core.platform

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.suhov.student.features.repository.LocalRepository

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val localRepository = LocalRepository().getInstance()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
