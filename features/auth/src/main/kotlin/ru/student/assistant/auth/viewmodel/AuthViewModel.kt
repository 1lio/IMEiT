package ru.student.assistant.auth.viewmodel

import androidx.lifecycle.*

class AuthViewModel : ViewModel() {

    private val state = MutableLiveData<AuthState>()
    private val lastState = MutableLiveData<AuthState>()

    private val actionEnabled = MutableLiveData<Boolean>()
    private val actionName = MutableLiveData<String>()

    init {
        state.value = AuthState.SIGN_IN
        actionName.value = ""
        actionEnabled.value = false
    }

    fun setLastState(state: AuthState) {
        lastState.postValue(state)
    }

    fun getLastState() = lastState.value

    fun setActionName(name: String) {
        actionName.value = name
    }

    fun observeActionName(owner: LifecycleOwner, observer: Observer<String>) {
        actionName.observe(owner, observer)
    }

    fun setState(state: AuthState) {
        this.state.postValue(state)
    }

    fun getState() = state.value

    fun observeState(owner: LifecycleOwner, observer: Observer<AuthState>) {
        state.observe(owner, observer)
    }

    fun observeEnableAction(owner: LifecycleOwner, observer: Observer<Boolean>) {
        actionEnabled.observe(owner, observer)
    }

    fun setEnableAction(boolean: Boolean) {
        actionEnabled.value = boolean
    }
}