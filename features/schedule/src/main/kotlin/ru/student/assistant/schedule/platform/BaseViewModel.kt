package ru.student.assistant.schedule.platform

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.student.assistant.repo.schedule.LocalRepository

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val localRepository = LocalRepository().getInstance()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
