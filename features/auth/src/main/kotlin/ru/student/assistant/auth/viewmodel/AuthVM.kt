package ru.student.assistant.auth.viewmodel

import androidx.lifecycle.*

class AuthVM : ViewModel() {

    private val state = MutableLiveData<Byte>()
    private val isEnabled = MutableLiveData<Boolean>()

    private val login = MutableLiveData<String>()       // Login or email
    private val pass = MutableLiveData<String>()
    private val rePass = MutableLiveData<String>()

    init {
        state.value = SIGN_IN
    }


    fun observeEnabled(owner: LifecycleOwner, observer: Observer<Boolean>){
        isEnabled.observe(owner, observer)
    }

    fun observeState(owner: LifecycleOwner, observer: Observer<Byte>) {
        state.observe(owner, observer)
    }

    fun setState(state: Byte) {
        this@AuthVM.state.value = state
        login.value = ""
        pass.value = ""
        rePass.value = ""
    }

    companion object {
        const val SIGN_IN: Byte = 0
        const val SIGN_UP: Byte = 1
        const val RESTORE: Byte = 2
    }

}
