package ru.student.assistant.calls

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.student.assistant.calls.repository.LocalRepository

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val localRepository = LocalRepository().getInstance()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
