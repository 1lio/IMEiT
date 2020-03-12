package ru.suhov.student.interactor

import io.reactivex.Observable
import io.reactivex.Single
import ru.suhov.student.entity.AuthData
import ru.suhov.student.entity.User

interface AccountInteractor {

    //Создание аккаунта
    fun createAccountEmail(authData: AuthData): Single<Boolean>

    // Получение аккаунта
    fun getAccount(uID: String): Observable<User>

    // Обноваление аккаунта
    fun updateAccount(uID: String, user: User): Single<Boolean>

    // Удаление аккаунта
    fun deleteAccountEmail(uID: String, email: String, pass: String): Single<Boolean>

    // Проверка авторизован ли пользователь
    fun isSigned(): Single<Boolean>

    // Получение ID Текущего пользователя
    fun getCurrentUserID(): String?

    // Авторизация
    fun signIn(email: String, pass: String): Single<Boolean>

    // Выход из аккаунта
    fun signOut(): Single<Boolean>
}