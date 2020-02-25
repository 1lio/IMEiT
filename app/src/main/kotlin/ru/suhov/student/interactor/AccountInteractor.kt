package ru.suhov.student.interactor

import io.reactivex.Observable
import io.reactivex.Single
import ru.suhov.student.entity.AuthData
import ru.suhov.student.entity.User

import ru.suhov.student.viewmodel.AuthViewModel
import ru.suhov.student.repository.FirebaseRealtimeRepository

/** Промежуточный слой между [AuthViewModel] и [FirebaseRealtimeRepository]*/
interface AccountInteractor {

    /** Создание аккаунта
     * @param authData - данные для создание пользователя
     * @return результат создания */
    fun createAccountEmail(authData: AuthData): Single<Boolean>

    /** Получение аккаунта
     * @param uID - индификатор пользователя
     * @return  сущность [User]*/
    fun getAccount(uID: String): Observable<User>

    /** Обноваление аккаунта
     * @param uID - id пользователя
     * @param user - пользовательсякие данные
     * @return результат обновления пользовательских данных */
    fun updateAccount(uID: String, user: User): Single<Boolean>

    /** Удаление аккаунта:
     * Перед тем как удалить аккаунт пользователю необходимо указать:
     * @param email - email совподающий с текущей учетной записью
     * @param pass - пароль от текущей записи
     * @param uID - ID пользователя, для удаления из БД
     * @return Результат удаления*/
    fun deleteAccountEmail(uID: String, email: String, pass: String): Single<Boolean>

    /** Проверка авторизован ли пользователь
     * @return Проверка авторизован ли пользователь */
    fun isSigned(): Single<Boolean>

    /** Получение ID Текущего пользователя
     * @return ID текущего пользователя*/
    fun getCurrentUserID(): String?

    /** Вход в аккаунт
     * Перед тем как войти в аккаунт пользователю необходимо указать:
     * @param email - email от учетной записи
     * @param pass - пароль от текущей записи */
    fun signIn(email: String, pass: String): Single<Boolean>

    /** Выход из аккаунта
     * @return результат выхода*/
    fun signOut(): Single<Boolean>
}