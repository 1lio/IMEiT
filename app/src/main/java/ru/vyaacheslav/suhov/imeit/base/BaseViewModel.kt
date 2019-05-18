package ru.vyaacheslav.suhov.imeit.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.vyaacheslav.suhov.imeit.repository.FirebaseRealtimeRepository
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.repository.MainInteractor

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val interactor = MainInteractor(FirebaseRealtimeRepository().getInstance())
    val localRepository = LocalRepository().getInstance()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
