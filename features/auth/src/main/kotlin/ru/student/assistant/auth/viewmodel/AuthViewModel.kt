package ru.student.assistant.auth.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.student.assistant.auth.gateway.AccountInteractor
import ru.student.assistant.auth.viewmodel.enums.AuthState
import ru.student.core.entity.AuthData
import ru.student.core.entity.User

open class AuthViewModel : AuthUI() {

    private val state = MutableLiveData<AuthState>()
    private val lastState = MutableLiveData<AuthState>()

    private val interactor = AccountInteractor()

    private val tryAuthData = MutableLiveData<Boolean>() // Попытка авторизации
    private val userData = MutableLiveData<User>()       // Сам пользователь

    // Coroutine
    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    //SignUp
    private val userAuth = AuthData()                    // данные для регистрации

    init {
        state.value = AuthState.SIGN_IN
    }

    // Авторизация

    override fun signIn() {
        super.signIn()

        tryAuthData.value = true // Флаг, попытка авторизации

        // Coroutine
        uiScope.launch {

            val result = interactor.signIn(getEmail(), getPass())
            setActionName(interactor.signIn(getEmail(), getPass()).toString())
        }
    }

    fun isAuth(): Boolean = false


    fun setLastState(state: AuthState) {
        lastState.postValue(state)
    }

    fun getLastState() = lastState.value

    fun setState(state: AuthState) {
        this.state.value = state
    }

    fun getState() = state.value

    fun observeState(owner: LifecycleOwner, observer: Observer<AuthState>) {
        state.observe(owner, observer)
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}