package ru.vyaacheslav.suhov.imeit.interactor

import io.reactivex.Observable
import io.reactivex.Single
import ru.vyaacheslav.suhov.imeit.entity.CallPref

interface TimeCallInteractor {

    fun createCustomUserCallsPref(uid: String, pref: CallPref): Single<Boolean>

    fun getUserTimePref(uid: String): Observable<CallPref>

    fun getDefaultTimeCallPref(): Single<CallPref>

    fun updateUserCallsPref(newPref: CallPref, uid: String): Single<Boolean>

    fun deleteUserCallsPref(uid: String): Single<Boolean>
}