package ru.vyaacheslav.suhov.imeit.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val isCorrectSignForm = MutableLiveData<Boolean>()
    private val userEmail = MutableLiveData<String>()
    private val userPass = MutableLiveData<String>()
    private val isAuthorization = MutableLiveData<Boolean>()

    init {
        isCorrectSignForm.value = false
        isAuthorization.value = false
    }

    fun getEmail(): String = userEmail.value ?: ""
    fun getPass(): String = userPass.value ?: ""

    fun observeLogin(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isAuthorization.observe(owner, observer)
    }

    fun login(isLogin:Boolean) {
        isAuthorization.value = isLogin
    }

    fun observeForms(owner: LifecycleOwner, observer: Observer<Boolean>) {
        isCorrectSignForm.observe(owner, observer)
    }

    fun setUserLogin(email: String, pass: String) {
        userEmail.value = email
        userPass.value = pass
    }

    fun setEnabledAll(b: Boolean) {
        isCorrectSignForm.value = b
    }
}