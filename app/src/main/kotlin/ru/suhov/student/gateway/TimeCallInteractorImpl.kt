package ru.suhov.student.gateway

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import io.reactivex.Single
import ru.suhov.student.entity.CallPref
import ru.suhov.student.interactor.TimeCallInteractor
import ru.suhov.student.repository.FirebaseRealtimeRepository
import ru.suhov.student.util.AppConstants.LOG_CALLS
import ru.suhov.student.util.Constants.CALL_REFERENCE
import ru.suhov.student.util.Constants.DEFAULT

class TimeCallInteractorImpl : TimeCallInteractor {

    private val instance: TimeCallInteractorImpl? = null

    private val repository = FirebaseRealtimeRepository().getInstance()

    /** Создаем пользовательские установки для времени звонков
     *  [updateUserCallsPref] - делат тоже самое, получилось небольщое дублирование */
    override fun createCustomUserCallsPref(uid: String, pref: CallPref): Single<Boolean> {
        Log.d(LOG_CALLS, "Func. createCustomUserCallsPref")
        return Single.create {
            repository.getRefUser(uid).child(CALL_REFERENCE).setValue(pref)
            it.onSuccess(true)
        }
    }

    /** Получить параметры для генерации времени звонков */
    override fun getDefaultTimeCallPref(): Single<CallPref> {
        Log.d(LOG_CALLS, "Func. getDefaultTimeCallPref")

        return Single.create {
            repository.getRefPreferencesCall(DEFAULT)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(p0: DataSnapshot) {
                        it.onSuccess(p0.getValue(CallPref::class.java) ?: CallPref())
                        Log.d(LOG_CALLS, "Done")
                    }

                    override fun onCancelled(p0: DatabaseError) {
                        it.onError(Throwable(p0.toString()))
                        Log.d(LOG_CALLS, "Error")
                    }
                })
        }
    }

    /** Настройки конкретного пользователя */
    override fun getUserTimePref(uid: String): Observable<CallPref> {
        Log.d(LOG_CALLS, "Func. getUserTimePref")

        return Observable.create {
            repository.getRefUser(uid).child(CALL_REFERENCE)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(p0: DataSnapshot) {
                        it.onNext(p0.getValue(CallPref::class.java) ?: CallPref())
                        Log.d(LOG_CALLS, "success")
                    }

                    override fun onCancelled(p0: DatabaseError) {
                        it.onError(Throwable(p0.toString()))
                        Log.d(LOG_CALLS, "Error")
                    }
                })
        }
    }

    /** Обновить пользовательские настройки */
    override fun updateUserCallsPref(newPref: CallPref, uid: String): Single<Boolean> {
        Log.d(LOG_CALLS, "Func. updateUserCallsPref")
        return Single.create {
            repository.getRefUser(uid).child(CALL_REFERENCE).setValue(newPref)
            it.onSuccess(true)
        }
    }

    /** Удалить данные */
    override fun deleteUserCallsPref(uid: String): Single<Boolean> {
        Log.d(LOG_CALLS, "Func. deleteUserCallsPref")
        return Single.create {
            repository.getRefUser(uid).child(CALL_REFERENCE).removeValue()
            it.onSuccess(true)
        }
    }

    fun getInstance() = this.instance ?: TimeCallInteractorImpl()
}