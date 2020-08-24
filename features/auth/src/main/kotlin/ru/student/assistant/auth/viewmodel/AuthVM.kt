package ru.student.assistant.auth.viewmodel

import androidx.lifecycle.*

class AuthVM : ViewModel() {

    private val state = MutableLiveData<Byte>()
    private var isFirstRun = true

    init {

    }

    fun observeState(owner: LifecycleOwner, observer: Observer<Byte>){
        state.observe(owner, observer)
    }

    fun setState(state: Byte){
        this@AuthVM.state.value = state
    }

    companion object {
        const val SIGN_IN: Byte = 0
        const val SIGN_UP: Byte = 1
        const val RESTORE: Byte = 2
    }

}
