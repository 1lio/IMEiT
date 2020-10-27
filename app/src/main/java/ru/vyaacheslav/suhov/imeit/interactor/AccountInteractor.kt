package ru.vyaacheslav.suhov.imeit.interactor

import io.reactivex.Observable
import io.reactivex.Single
import ru.vyaacheslav.suhov.imeit.entity.AuthData
import ru.vyaacheslav.suhov.imeit.entity.User

import ru.vyaacheslav.suhov.imeit.viewmodel.AuthViewModel
import ru.vyaacheslav.suhov.imeit.repository.FirebaseRealtimeRepository

interface AccountInteractor {

    fun createAccountEmail(authData: AuthData): Single<Boolean>

    fun getAccount(uID: String): Observable<User>

    fun updateAccount(uID: String, user: User): Single<Boolean>

    fun deleteAccountEmail(uID: String, email: String, pass: String): Single<Boolean>

    fun isSigned(): Single<Boolean>

    fun getCurrentUserID(): String?

    fun signIn(email: String, pass: String): Single<Boolean>

    fun signOut(): Single<Boolean>
}