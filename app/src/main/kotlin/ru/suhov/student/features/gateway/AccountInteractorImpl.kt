package ru.suhov.student.features.gateway

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import ru.suhov.student.features.repository.FirebaseRealtimeRepository
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single
import ru.suhov.student.core.entity.AuthData
import ru.suhov.student.features.interactor.AccountInteractor
import ru.suhov.student.core.entity.User
import ru.suhov.student.core.util.AppConstants.LOG_ACCOUNT

import ru.suhov.student.features.viewmodel.AuthViewModel

/** Реализация [AccountInteractor]. Работа в [AuthViewModel] */

class AccountInteractorImpl : AccountInteractor {

    private val instance: AccountInteractorImpl? = null

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseRealtimeRepository().getInstance()

    /** Создание аккаунта */
    override fun createAccountEmail(authData: AuthData): Single<Boolean> {

        Log.d(LOG_ACCOUNT, "Func. Create Account Email")
        return Single.create { subscribe ->
            auth.createUserWithEmailAndPassword(authData.email, authData.pass)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        // Получаем пользователя
                        auth.currentUser
                        // Если все хорошо, создаем учетку пользователя
                        Log.d(LOG_ACCOUNT, "Account created")
                        authData.user.updateAccountInDB(getCurrentUserID())
                        subscribe.onSuccess(true)
                    } else {
                        subscribe.onError(Throwable())
                        Log.d(LOG_ACCOUNT, "Account is not created")
                    }
                }
        }
    }

    /** Вход пользователя */
    override fun signIn(email: String, pass: String): Single<Boolean> {

        Log.d(LOG_ACCOUNT, "Func. SignIn")
        return Single.create { subscribe ->
            auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        auth.currentUser
                        getAccount(getCurrentUserID())
                        Log.d(LOG_ACCOUNT, "SignIn : true")
                        subscribe.onSuccess(true)
                    } else {
                        Log.d(LOG_ACCOUNT, "SignIn : false")
                        subscribe.onError(Throwable())
                    }
                }
        }
    }

    /** Получение текущего аккаунта */
    override fun getAccount(uID: String): Observable<User> {

        Log.d(LOG_ACCOUNT, "Func. getAccount from ID")

        return Observable.create {
            db.getRefUser(uID).addListenerForSingleValueEvent(object : ValueEventListener {
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
    override fun updateAccount(uID: String, user: User): Single<Boolean> {

        Log.d(LOG_ACCOUNT, "Func. updateAccount")
        // Не используетсся
        return Single.create {
            Log.d(LOG_ACCOUNT, "Func. updateAccount from ID")
            user.updateAccountInDB(uID)
            it.onSuccess(true)
        }
    }

    /** Удаление аккаунта */
    override fun deleteAccountEmail(uID: String, email: String, pass: String): Single<Boolean> {

        Log.d(LOG_ACCOUNT, "Func. deleteAccountEmail")
        val user = auth.currentUser
        val credential = EmailAuthProvider.getCredential(email, pass)

        return Single.create { subscribe ->
            user!!.reauthenticate(credential).addOnCompleteListener { user.delete() }
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        db.getRefUser(uID).removeValue()
                        Log.d(LOG_ACCOUNT, "Account deleted")
                        subscribe.onSuccess(true)
                    } else {
                        subscribe.onError(Throwable())
                        Log.d(LOG_ACCOUNT, "Error account deleted")
                    }
                }
        }
    }

    /** Проверка вошел ли пользователь */
    override fun isSigned(): Single<Boolean> {

        Log.d(LOG_ACCOUNT, "Func. isSigned")
        return Single.create<Boolean> {

            if (auth.currentUser != null) {
                it.onSuccess(true)
                Log.d(LOG_ACCOUNT, "is Signed account")
            } else {
                it.onError(Throwable())
                Log.d(LOG_ACCOUNT, "is not Signed account")
            }

        }
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
            Log.d(LOG_ACCOUNT, "Sign out account")
            it.onSuccess(true)
        }
    }

    /** Создание учетной записи в БД*/
    private fun User.updateAccountInDB(id: String) {
        db.getRefUser(id).setValue(this@updateAccountInDB)
        Log.d(LOG_ACCOUNT, "Account $id updated in DB")
    }

    fun getInstance() = this.instance ?: AccountInteractorImpl()
}