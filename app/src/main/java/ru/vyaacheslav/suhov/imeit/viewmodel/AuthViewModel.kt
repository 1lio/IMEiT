package ru.vyaacheslav.suhov.imeit.viewmodel

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.vyaacheslav.suhov.imeit.entity.AuthData
import ru.vyaacheslav.suhov.imeit.gateway.AccountInteractorImpl
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.entity.User
import ru.vyaacheslav.suhov.imeit.util.AppConstants.LOG_ACCOUNT
import ru.vyaacheslav.suhov.imeit.util.Constants

class AuthViewModel : ViewModel() {

    private val interactor = AccountInteractorImpl().getInstance()
    private val localRepository = LocalRepository().getInstance()
    private val compositeDisposable = CompositeDisposable()

    private val isAuthData = MutableLiveData<Boolean>()  // Авторизован ди пользователь
    private val tryAuthData = MutableLiveData<Boolean>() // Попытка авторизации
    private val userData = MutableLiveData<User>()       // Сам пользователь

    // Sign In
    private val emailData = MutableLiveData<String>()    // email
    private val passData = MutableLiveData<String>()     // пароль

    //SignUp
    private val userAuth = AuthData()

    init {
        isAuthData.value = localRepository.isAuth
        if (localRepository.isAuth) getUser()
    }

    /** Авторизация */
    fun signIn() {
        tryAuthData.value = true

        val email = emailData.value ?: Constants.NOT_SELECT
        val pass = passData.value ?: Constants.NOT_SELECT

        interactor
                .signIn(email, pass)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ if (it) setAuth(true) },{ setAuth(false) })
                .apply { compositeDisposable.add(this) }
    }

    /** Регистрация*/
    fun signUp() {

        interactor.createAccountEmail(userAuth)
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({if (it) setAuth(true)},{})
                .apply { compositeDisposable.add(this) }

        userData.value = userAuth.user
    }

    fun signOut() {
        interactor.signOut()
        isAuthData.value = false
        localRepository.isAuth = false
    }

    private fun setAuth(auth: Boolean) {
        isAuthData.postValue(auth)
        localRepository.isAuth = auth

        if (auth) {
            localRepository.userId = interactor.getCurrentUserID()
            getUser()
        }

        tryAuthData.value = false
    }

    private fun getUser() {
        interactor
                .getAccount(localRepository.userId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { userData.postValue(it) }
                .apply { compositeDisposable.add(this) }
    }

    fun isSigned(): Boolean = isAuthData.value ?: false

    /** Передача пользовательских данных*/
    fun setUserData(user: User) {
        userAuth.user = user
    }

    /** Передача email и пароля для входа*/
    fun setSignInLogin(email: String, pass: String) {
        emailData.postValue(email)
        passData.postValue(pass)
        Log.d(LOG_ACCOUNT, "$email $pass")
    }

    /** Передача email и пароля для регистрации*/
    fun setSignUpLogin(email: String, pass: String) {
        userAuth.email = email
        userAuth.pass = pass
    }

    /** Наблюдение за авторизацией*/
    fun observeAuth(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isAuthData.observe(owner, observer)
    }

    /** Наблюдение за попыткой авторизации*/
    fun observeTryAuth(owner: LifecycleOwner, observer: Observer<Boolean>) {
        tryAuthData.observe(owner, observer)
    }

    /** Наблюдение за пользовательскими данными*/
    fun observeUser(owner: LifecycleOwner, observer: Observer<User>) {
        userData.observe(owner, observer)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}