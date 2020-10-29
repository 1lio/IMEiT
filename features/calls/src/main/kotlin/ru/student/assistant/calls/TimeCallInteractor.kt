package ru.student.assistant.calls

import io.reactivex.Observable
import io.reactivex.Single
import ru.student.assistant.core.entity.CallPref

interface TimeCallInteractor {

    /** Создать пользовательские установки для звонков
     *  @param uid - id пользователя
     *  @return Результат создания пользовательских установок*/
    fun createCustomUserCallsPref(uid: String, pref: CallPref): Single<Boolean>

    /** Получить установки для времени звонков типа [CallPref]
     *  @param uid - id пользователя
     * @return - Установки  звонков*/
    fun getUserTimePref(uid: String): Observable<CallPref>

    /** Стандартные настройки времени звонков */
    fun getDefaultTimeCallPref(): Single<CallPref>

    /** Обновить данные
     * *  @param uid - id пользователя
     *  @return подтверждение обновления */
    fun updateUserCallsPref(newPref: CallPref, uid: String): Single<Boolean>

    /** Удалить пользовательские настройки для звонков
     *  @param uid - id пользователя
     */
    fun deleteUserCallsPref(uid: String): Single<Boolean>
}