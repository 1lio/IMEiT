package ru.vyaacheslav.suhov.imeit.gateway

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

class AccountInteractorImpl : AccountInteractor {

    private val instance: AccountInteractorImpl? = null

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseRealtimeRepository().getInstance()

    override fun createAccountEmail(authData: AuthData): Single<Boolean> {
        return Single.create { subscribe ->
            auth.createUserWithEmailAndPassword(authData.email, authData.pass)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            // Получаем пользователя
                            auth.currentUser
                            // Если все хорошо, создаем учетку пользователя
                            authData.user.updateAccountInDB(getCurrentUserID())
                            subscribe.onSuccess(true)
                        } else {
                            subscribe.onError(Throwable())
                        }
                    }
        }
    }

    override fun signIn(email: String, pass: String): Single<Boolean> {
        return Single.create { subscribe ->
            auth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            auth.currentUser
                            getAccount(getCurrentUserID())
                            subscribe.onSuccess(true)
                        } else {
                            subscribe.onError(Throwable())
                        }
                    }
        }
    }

    override fun getAccount(uID: String): Observable<User> {
        return Observable.create {
            db.getRefUser(uID).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    it.onNext(snapshot.getValue(User::class.java) ?: User())
                }

                override fun onCancelled(error: DatabaseError) {
                    it.onError(Throwable(error.toString()))
                }
            })
        }
    }

    override fun updateAccount(uID: String, user: User): Single<Boolean> {
        return Single.create {
            user.updateAccountInDB(uID)
            it.onSuccess(true)
        }
    }

    override fun deleteAccountEmail(uID: String, email: String, pass: String): Single<Boolean> {

        val user = auth.currentUser
        val credential = EmailAuthProvider.getCredential(email, pass)

        return Single.create { subscribe ->
            user!!.reauthenticate(credential).addOnCompleteListener { user.delete() }
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            db.getRefUser(uID).removeValue()
                            subscribe.onSuccess(true)
                        } else {
                            subscribe.onError(Throwable())
                        }
                    }
        }
    }

    override fun isSigned(): Single<Boolean> {
        return Single.create {
            if (auth.currentUser != null) {
                it.onSuccess(true)
            } else {
                it.onError(Throwable())
            }

        }
    }

    override fun getCurrentUserID(): String {
        return auth.currentUser?.uid ?: ""
    }

    override fun signOut(): Single<Boolean> {
        return Single.create {
            auth.signOut()
            it.onSuccess(true)
        }
    }

    private fun User.updateAccountInDB(id: String) {
        db.getRefUser(id).setValue(this@updateAccountInDB)
    }

    fun getInstance() = this.instance ?: AccountInteractorImpl()
}