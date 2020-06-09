package ru.suhov.student.features.viewmodel

import android.util.Log
import androidx.lifecycle.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.suhov.student.core.platform.BaseViewModel
import ru.suhov.student.core.entity.AuthData
import ru.suhov.student.core.entity.User
import ru.suhov.student.features.gateway.AccountInteractorImpl
import ru.suhov.student.features.AppConstants.LOG_ACCOUNT
import ru.suhov.student.features.Constants.NOT_SELECT
import java.util.concurrent.TimeUnit

class AuthViewModel : BaseViewModel() {

    private val interactor = AccountInteractorImpl().getInstance()
    private val authErrors = MutableLiveData<Byte>()     // Ошибки авторизации
    private val tryAuthData = MutableLiveData<Boolean>() // Попытка авторизации
    private val userData = MutableLiveData<User>()

    // Sign In
    private val emailData = MutableLiveData<String>()    // email
    private val passData = MutableLiveData<String>()     // пароль
    private val isAuthData = MutableLiveData<Boolean>()  // Авторизован ди пользователь

    //SignUp
    private val userAuth = AuthData()

    private val state = MutableLiveData<AuthState>()
    private val lastState = MutableLiveData<AuthState>()

    private val actionEnabled = MutableLiveData<Boolean>()
    private val actionName = MutableLiveData<String>()

    init {
        isAuthData.value = localRepository.isAuth
        if (localRepository.isAuth) getUser()

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

    fun getEnableAction() = actionEnabled.value

    // Авторизация
    fun signIn() {
        tryAuthData.value = true // Флаг, попытка авторизации

        val email = emailData.value ?: NOT_SELECT
        val pass = passData.value ?: NOT_SELECT

        // обрабатываем ответ от сервера. Ждем 2 секунды
        interactor
            .signIn(email, pass)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .delay(2L, TimeUnit.SECONDS)
            .subscribe({ if (it) setAuthStatus(it) }, { setErrorMsg(1) })
            .apply { compositeDisposable.add(this) }
    }

    // Регистрация
    fun signUp() {
        tryAuthData.value = true

        interactor
            .createAccountEmail(userAuth)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .delay(2L, TimeUnit.SECONDS)
            .subscribe({ setAuthStatus(it) }, { setErrorMsg(2) })
            .apply { compositeDisposable.add(this) }
    }

    // Выход из приложения

    fun signOut() {
        // Данную задачу можно кинуть на фон
        interactor.signOut()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                isAuthData.postValue(false)
                localRepository.isAuth = false
            }, {})
            .apply { compositeDisposable.add(this) }
    }

    // Установить статус авториззации
    private fun setAuthStatus(auth: Boolean) {

        tryAuthData.postValue(false)
        // Что-то происходит
        localRepository.isAuth = auth
        if (auth) {
            localRepository.userId = interactor.getCurrentUserID()
            getUser()
        }
        userData.postValue(userAuth.user)
        // Готоврим что все гуд или нет
        isAuthData.postValue(auth)
    }

    // Пользовательские данные
    private fun getUser() {
        interactor
            .getAccount(localRepository.userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ userData.postValue(it) }, {})
            .apply { compositeDisposable.add(this) }
    }

    // Проверка на авторизацию
    fun isSigned(): Boolean = isAuthData.value ?: false

    // Передача пользовательских данных
    fun setUserData(user: User) {
        userAuth.user = user
    }

    // Передача email и пароля для входа
    fun setSignInLogin(email: String, pass: String) {
        emailData.postValue(email)
        passData.postValue(pass)
        Log.d(LOG_ACCOUNT, "$email $pass")
    }

    // Передача email и пароля для регистрации
    fun setSignUpLogin(email: String, pass: String) {
        userAuth.email = email
        userAuth.pass = pass
    }

    // Наблюдение за авторизацией
    fun observeAuth(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isAuthData.observe(owner, observer)
    }

    // Наблюдение за попыткой авторизации
    fun observeTryAuth(owner: LifecycleOwner, observer: Observer<Boolean>) {
        tryAuthData.observe(owner, observer)
    }

    // Наблюдение за пользовательскими данными
    fun observeUser(owner: LifecycleOwner, observer: Observer<User>) {
        userData.observe(owner, observer)
    }

    // наблюдение за ошибками
    fun observeAuthErrorsMsg(owner: LifecycleOwner, observer: Observer<Byte>) {
        authErrors.observe(owner, observer)
    }

    // Установить ошибку
    private fun setErrorMsg(msgId: Byte) {
        authErrors.postValue(msgId)
        tryAuthData.postValue(false)
    }
}