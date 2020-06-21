package ru.student.assistant.auth.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import ru.student.assistant.auth.viewmodel.enums.AuthAction

// Поведение View в AuthFragment
open class AuthUI : ViewModel() {

    // Главная кнопка отражающая действие /Логин/Регистрация/Восстановление
    private val action = MutableLiveData<AuthAction>()
    private val actionName = MutableLiveData<String>()

    // Поля в окнах
    private val email = MutableLiveData<String>()
    private val pass = MutableLiveData<String>()
    private val license = MutableLiveData<Boolean>()

    // Кнопка action
    private val enabledAction = MutableLiveData<Boolean>()
    private val tapAction = MutableLiveData<Boolean>()

    // Загрузка
    private val loader = MutableLiveData<Boolean>()

    // Ошибка
    private val errorMsg = MutableLiveData<String>()


    init {

        enabledAction.value = false
        tapAction.value = false
        loader.value = false
    }

    suspend fun sendAction(action: AuthAction) {
        tapAction.value = true            // Кнопка нажата
        enabledAction.value = false       // Блочим кнопку
        loader.value = true               // Выводим лоадер
        delay(100)              // задержка
        tapAction.postValue(false)  // Отжимаем

        // Обрабатываем

        when (action) {
            AuthAction.SIGN_IN -> signIn()
            AuthAction.SIGN_UP -> signUp()
            AuthAction.RESTORE -> restore()
            else -> return
        }
    }


    // Основные действия

    open fun signIn() {
        // Чет делаем

        var result = true

        if (result) {
            // Оптравляем на новое окно
        } else {

        }


    }

    open fun signUp() {}

    open fun restore() {}


    // Получение полей

    fun getEmail() = email.value ?: ""
    fun getPass() = pass.value ?: ""
    fun checkLicense() = license.value ?: false

    // изменение

    fun setEmail(mail: String) {
        email.value = mail
    }

    fun setPass(password: String) {
        pass.value = password
    }

    fun setLicense(check: Boolean) {
        license.value = check
    }

    fun setActionName(name: String) {
        actionName.value = name
    }

    fun setEnableAction(e:Boolean) {enabledAction.value = e}

    // Наблюденеи

    fun observeActionName(owner: LifecycleOwner, observer: Observer<String>) {
        actionName.observe(owner, observer)
    }

    fun observeActionEnabled(owner: LifecycleOwner, observer: Observer<Boolean>) {
        enabledAction.observe(owner, observer)
    }

    fun observeLoader(owner: LifecycleOwner, observer: Observer<Boolean>) {
        loader.observe(owner, observer)
    }

    fun observeTap(owner: LifecycleOwner, observer: Observer<Boolean>) {
        tapAction.observe(owner, observer)
    }

    fun observeErrorMsg(owner: LifecycleOwner, observer: Observer<String>) {
        errorMsg.observe(owner, observer)
    }

}