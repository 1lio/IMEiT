package ru.student.assistant.auth.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.student.assistant.auth.gateway.AccountInteractor
import ru.student.assistant.auth.viewmodel.enums.AuthState
import ru.student.core.entity.AuthData
import ru.student.core.entity.User

class AuthViewModel : ViewModel() {

    private val state = MutableLiveData<AuthState>()
    private val lastState = MutableLiveData<AuthState>()

    private val actionEnabled = MutableLiveData<Boolean>()
    private val actionName = MutableLiveData<String>()

    private val email = MutableLiveData<String>()
    private val pass = MutableLiveData<String>()

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
        actionEnabled.value = false

    }

    // Авторизация
    fun signIn() {

        tryAuthData.value = true // Флаг, попытка авторизации

        // Coroutine
        uiScope.launch {

            val result = interactor.signIn(getEmail(), getPass())


            actionName.postValue(interactor.signIn(getEmail(), getPass()).toString())
        }

        // RxJava
        /*   interactor
               .signIn(email, pass)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .delay(2L, TimeUnit.SECONDS)
               .subscribe(
                         { actionName.postValue(interactor.signIn(getEmail(), getPass()).toString()) },
                         { setErrorMsg(ERROR_LOGIN) })
               .apply { compositeDisposable.add(this) }*/
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
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
        this.state.value = state
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

    // Field
    fun getEmail(): String = email.value ?: ""

    private fun getPass(): String = pass.value ?: ""

    fun observeEmail(owner: LifecycleOwner, observer: Observer<String>) {
        email.observe(owner, observer)
    }

    fun setEmail(mail: String) {
        email.value = mail
    }

    fun setPass(password: String) {
        email.value = password
    }
}