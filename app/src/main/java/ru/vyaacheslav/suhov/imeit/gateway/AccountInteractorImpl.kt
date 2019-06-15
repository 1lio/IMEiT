package ru.vyaacheslav.suhov.imeit.gateway

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.repository.FirebaseRealtimeRepository
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single
import ru.vyaacheslav.suhov.imeit.entity.AuthData
import ru.vyaacheslav.suhov.imeit.interactor.AccountInteractor
import ru.vyaacheslav.suhov.imeit.entity.User
import ru.vyaacheslav.suhov.imeit.util.AppConstants.LOG_ACCOUNT

import ru.vyaacheslav.suhov.imeit.viewmodel.AuthViewModel

/** Реализация [AccountInteractor]. Работа в [AuthViewModel] */

class AccountInteractorImpl : AccountInteractor {

    private val instance: AccountInteractorImpl? = null

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseRealtimeRepository().getInstance()

    /** Создание аккаунта */
    override fun createAccountEmail(authData: AuthData): Observable<Boolean> {

        Log.d(LOG_ACCOUNT, "Func. Create Account Email")

        var result = false
        return Observable.create { subscribe ->

           for (x in 0..2) {
                auth.createUserWithEmailAndPassword(authData.email, authData.pass)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                // Получаем пользователя
                                auth.currentUser
                                // Если все хорошо, создаем учетку пользователя
                                authData.user.updateAccountInDB(getCurrentUserID())

                                Log.d(LOG_ACCOUNT, "Account created")
                                result = true
                                subscribe.onNext(result)
                            }
                        }

                if (x == 2 && !result) {
                    result = false
                    Log.d(LOG_ACCOUNT, "Account is not created")
                    subscribe.onError(Throwable())
                }
                Log.d(LOG_ACCOUNT, "Try create account $x: $result $authData")
                Thread.sleep(1000)
            }
            subscribe.onComplete()
        }

    }

    /** Вход пользователя */
    override fun signIn(email: String, pass: String): Observable<Boolean> {

        Log.d(LOG_ACCOUNT, "Func. signIn")
        var result = false

        return Observable.create { subscribe ->
            for (x in 0..2) {
                auth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener {
                            result = it.isSuccessful
                            subscribe.onNext(result)

                            if (result) {
                                auth.currentUser
                                subscribe.onComplete()
                                getAccount(getCurrentUserID())
                            }

                            Log.d(LOG_ACCOUNT, "SignIn attempt $x: $result")
                        }
                Thread.sleep(1000L)
                if (x == 2 && !result) subscribe.onError(Throwable())
            }

            Log.d(LOG_ACCOUNT, "SignIn : $result")
        }
    }

    /** Получение текущего аккаунта */
    override fun getAccount(uID: String): Observable<User> {

        Log.d(LOG_ACCOUNT, "Func. getAccount from ID")

        return Observable.create {

            db.getRefUser(uID)
                    .addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            it.onNext(snapshot.getValue(User::class.java) ?: User())
                            Log.d(LOG_ACCOUNT, "Return Observable User")
                        }

                        override fun onCancelled(error: DatabaseError) {
                            it.onError(Throwable(error.toString()))
                            Log.d(LOG_ACCOUNT, "Observable User Canceled: $error")
                        }
                    })
        }
    }

    /** Обновление пользовательских данных */
    override fun updateAccount(uID: String, user: User): Observable<Boolean> {

        // Не используетсся
        return Observable.create {
            Log.d(LOG_ACCOUNT, "Func. updateAccount from ID")
            user.updateAccountInDB(uID)
            it.onNext(true)
        }
    }

    /** Удаление аккаунта */
    override fun deleteAccountEmail(uID: String, email: String, pass: String): Observable<Boolean> {

        val user = auth.currentUser
        val credential = EmailAuthProvider.getCredential(email, pass)
        return Observable.create { subscribe ->
            for (x in 0..2) {
                user!!.reauthenticate(credential).addOnCompleteListener { user.delete() }
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                db.getRefUser(uID).removeValue()
                                Log.d(LOG_ACCOUNT, "Account deleted")
                                subscribe.onNext(true)
                            } else {
                                subscribe.onError(Throwable())
                                Log.d(LOG_ACCOUNT, "Error account deleted")
                            }
                        }
            }
            subscribe.onComplete()
        }

    }

    /** Проверка вошел ли пользователь */
    override fun isSigned(): Observable<Boolean> {

        Log.d(LOG_ACCOUNT, "Func. isSigned")

        val signed = Observable.create<Boolean> {
            for (i in 0..2) {
                Thread.sleep(1000)
                it.onNext(auth.currentUser != null)
            }
            it.onComplete()
        }

        Log.d(LOG_ACCOUNT, "isSigned account")
        return signed
    }

    /** ID Текущего пользователя */
    override fun getCurrentUserID(): String {
        val id = auth.currentUser?.uid ?: ""
        Log.d(LOG_ACCOUNT, "Func. getCurrentUserID: $id")
        return id
    }

    /** Выход из учетной записи*/
    override fun signOut(): Single<Boolean> {
        return Single.create {
            auth.signOut()
            it.onSuccess(true)
            Log.d(LOG_ACCOUNT, "Sign out account")
        }
    }

    /** Создание учетной записи в БД*/
    private fun User.updateAccountInDB(id: String) {
        db.getRefUser(id).setValue(this@updateAccountInDB)
        Log.d(LOG_ACCOUNT, "Account updated")
    }

    fun getInstance() = this.instance ?: AccountInteractorImpl()
}