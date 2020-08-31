package ru.student.assistant.auth.gateway

import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccountInteractor : Auth {

    private val auth = Firebase.auth

    @Throws(FirebaseAuthWeakPasswordException::class)
    override suspend fun signIn(email: String, pass: String): Boolean {

        var result = false

     /*   auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            result = when {
                it.isSuccessful -> {
                    true
                }
                it.isComplete -> {
                    true
                }
                it.isCanceled -> {
                    false
                }
                else -> false
            }
        }*/


        return result
    }

/*
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    auth.currentUser
                    // getAccount(getCurrentUserID())
                    result = true
                    Log.d(LOG_TAG, "SignIn : true")
                } else {
                    result = false
                    Log.d(LOG_TAG, "SignIn : false")
                }
            }

        return result*/


/*        val sendStatus = async(CommonPool) {
            sendEmail(recipient.await(), msg.await()) //(7)
        }
        return sendStatus.await() //(8)*/


    /*  return Single.create { subscribe ->
          auth.signInWithEmailAndPassword(email, pass)
              .addOnCompleteListener {
                  if (it.isSuccessful) {
                      auth.currentUser
                      getAccount(getCurrentUserID())
                      Log.d(LOG_TAG, "SignIn : true")
                      subscribe.onSuccess(true)
                  } else {
                      Log.d(LOG_TAG, "SignIn : false")
                      subscribe.onError(Throwable())
                  }
              }
      }*/


    override suspend fun signOut(): Boolean {
        return false
    }

    override suspend fun isSigned(): Boolean {
        return false
    }

    override fun restore(email: String) {
       auth.sendPasswordResetEmail(email)
    }

    override fun getCurrentUserID(): String? {
        return ""
    }


    private companion object {
        const val LOG_TAG = "AccountInteractor"
    }
}

/** Создание аккаунта */


/* override fun createAccountEmail(authData: AuthData): Single<Boolean> {

     Log.d(LOG_TAG, "Func. Create Account Email")
     return Single.create { subscribe ->
         auth.createUserWithEmailAndPassword(authData.email, authData.pass)
             .addOnCompleteListener {
                 if (it.isSuccessful) {
                     // Получаем пользователя
                     auth.currentUser
                     // Если все хорошо, создаем учетку пользователя
                     Log.d(LOG_TAG, "Account created")
                     authData.user.updateAccountInDB(getCurrentUserID())
                     subscribe.onSuccess(true)
                 } else {
                     subscribe.onError(Throwable())
                     Log.d(LOG_TAG, "Account is not created")
                 }
             }
     }
 }

 */
/** Вход пользователя *//*

    override fun signIn(email: String, pass: String): Single<Boolean> {

        Log.d(LOG_TAG, "Func. SignIn")
        return Single.create { subscribe ->
            auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        auth.currentUser
                        getAccount(getCurrentUserID())
                        Log.d(LOG_TAG, "SignIn : true")
                        subscribe.onSuccess(true)
                    } else {
                        Log.d(LOG_TAG, "SignIn : false")
                        subscribe.onError(Throwable())
                    }
                }
        }
    }

    */
/** Получение текущего аккаунта *//*

    override fun getAccount(uID: String): Observable<User> {

        Log.d(LOG_TAG, "Func. getAccount from ID")

        return Observable.create {
            db.getRefUser(uID).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    it.onNext(snapshot.getValue(User::class.java) ?: User())
                    Log.d(LOG_TAG, "Return Observable User")
                }

                override fun onCancelled(error: DatabaseError) {
                    it.onError(Throwable(error.toString()))
                    Log.d(LOG_TAG, "Observable User Canceled: $error")
                }
            })
        }
    }

    */
/** Обновление пользовательских данных *//*

    override fun updateAccount(uID: String, user: User): Single<Boolean> {

        Log.d(LOG_TAG, "Func. updateAccount")
        // Не используетсся
        return Single.create {
            Log.d(LOG_TAG, "Func. updateAccount from ID")
            user.updateAccountInDB(uID)
            it.onSuccess(true)
        }
    }

    */
/** Удаление аккаунта *//*

    override fun deleteAccountEmail(uID: String, email: String, pass: String): Single<Boolean> {

        Log.d(LOG_TAG, "Func. deleteAccountEmail")
        val user = auth.currentUser
        val credential = EmailAuthProvider.getCredential(email, pass)

        return Single.create { subscribe ->
            user!!.reauthenticate(credential).addOnCompleteListener { user.delete() }
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        db.getRefUser(uID).removeValue()
                        Log.d(LOG_TAG, "Account deleted")
                        subscribe.onSuccess(true)
                    } else {
                        subscribe.onError(Throwable())
                        Log.d(LOG_TAG, "Error account deleted")
                    }
                }
        }
    }

    */
/** Проверка вошел ли пользователь *//*

    override fun isSigned(): Single<Boolean> {

        Log.d(LOG_TAG, "Func. isSigned")
        return Single.create<Boolean> {

            if (auth.currentUser != null) {
                it.onSuccess(true)
                Log.d(LOG_TAG, "is Signed account")
            } else {
                it.onError(Throwable())
                Log.d(LOG_TAG, "is not Signed account")
            }

        }
    }

    */
/** ID Текущего пользователя *//*

    override fun getCurrentUserID(): String {
        val id = auth.currentUser?.uid ?: ""
        Log.d(LOG_TAG, "Func. getCurrentUserID: $id")
        return id
    }

    */
/** Выход из учетной записи*//*

    override fun signOut(): Single<Boolean> {
        return Single.create {
            auth.signOut()
            Log.d(LOG_TAG, "Sign out account")
            it.onSuccess(true)
        }
    }

    */
/** Создание учетной записи в БД*//*

    private fun User.updateAccountInDB(id: String) {
        db.getRefUser(id).setValue(this@updateAccountInDB)
        Log.d(LOG_TAG, "Account $id updated in DB")
    }

    fun getInstance() = this.instance ?: AccountInteractorImpl() */