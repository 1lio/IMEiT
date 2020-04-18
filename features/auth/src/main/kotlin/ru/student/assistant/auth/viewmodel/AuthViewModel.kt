package ru.student.assistant.auth.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.student.assistant.auth.entity.AuthData
import ru.student.core.base.Repository
import ru.student.core.entity.User
import ru.student.core.impl.LocalRepository

class AuthViewModel() : ViewModel() {

    private val repository: Repository = LocalRepository()

    // SIGN_IN,SIGN_UP,SIGN_OUT,CONNECTED,RESTORE, CHECKING
    private val authState = MutableLiveData<Byte>()
    private val lastState = MutableLiveData<Byte>()

    private val isAuthorized = MutableLiveData<Boolean>()

    private val authData = AuthData()
    private val userData = MutableLiveData<User>()

    private val actionEnabled = MutableLiveData<Boolean>()

    init {
        isAuthorized.value = repository.isAuth
    }

    fun observeState(owner: LifecycleOwner, observer: Observer<Byte>){
        authState.observe(owner, observer)
    }

    fun observeEnableAction(owner: LifecycleOwner, observer: Observer<Boolean>) {
        actionEnabled.observe(owner, observer)
    }
    fun setEnableAction(boolean: Boolean) {
        actionEnabled.value = boolean
    }

    fun getEnableAction() = actionEnabled.value

    fun setState(state: Byte) {
        lastState.value = authState.value
        authState.value = state
    }

    fun getState() = authState.value
    fun getLastState() = lastState.value

}