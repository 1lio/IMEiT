package ru.vyaacheslav.suhov.imeit.gateway

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import io.reactivex.Single
import ru.vyaacheslav.suhov.imeit.entity.CallPref
import ru.vyaacheslav.suhov.imeit.interactor.TimeCallInteractor
import ru.vyaacheslav.suhov.imeit.repository.FirebaseRealtimeRepository
import ru.vyaacheslav.suhov.imeit.util.Constants.CALL_REFERENCE
import ru.vyaacheslav.suhov.imeit.util.Constants.DEFAULT

class TimeCallInteractorImpl : TimeCallInteractor {

    private val instance: TimeCallInteractorImpl? = null

    private val repository = FirebaseRealtimeRepository().getInstance()

    // Создаем пользовательские установки для времени звонков
    override fun createCustomUserCallsPref(uid: String, pref: CallPref): Single<Boolean> {
        return Single.create {
            repository.getRefUser(uid).child(CALL_REFERENCE).setValue(pref)
            it.onSuccess(true)
        }
    }

    // Получить параметры для генерации времени звонков
    override fun getDefaultTimeCallPref(): Single<CallPref> {
        return Single.create {
            repository.getRefPreferencesCall(DEFAULT)
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(p0: DataSnapshot) {
                            it.onSuccess(p0.getValue(CallPref::class.java) ?: CallPref())
                        }

                        override fun onCancelled(p0: DatabaseError) {
                            it.onError(Throwable(p0.toString()))
                        }
                    })
        }
    }

    // Настройки конкретного пользователя
    override fun getUserTimePref(uid: String): Observable<CallPref> {
        return Observable.create {
            repository.getRefUser(uid).child(CALL_REFERENCE)
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(p0: DataSnapshot) {
                            it.onNext(p0.getValue(CallPref::class.java) ?: CallPref())
                        }

                        override fun onCancelled(p0: DatabaseError) {
                            it.onError(Throwable(p0.toString()))
                        }
                    })
        }
    }

    // Обновить пользовательские настройки
    override fun updateUserCallsPref(newPref: CallPref, uid: String): Single<Boolean> {
        return Single.create {
            repository.getRefUser(uid).child(CALL_REFERENCE).setValue(newPref)
            it.onSuccess(true)
        }
    }

    // Удалить данные
    override fun deleteUserCallsPref(uid: String): Single<Boolean> {
        return Single.create {
            repository.getRefUser(uid).child(CALL_REFERENCE).removeValue()
            it.onSuccess(true)
        }
    }

    fun getInstance() = this.instance ?: TimeCallInteractorImpl()
}