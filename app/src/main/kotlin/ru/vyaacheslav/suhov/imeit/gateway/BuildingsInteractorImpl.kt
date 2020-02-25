package ru.vyaacheslav.suhov.imeit.gateway

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import io.reactivex.Single
import ru.vyaacheslav.suhov.imeit.entity.EduBuilding
import ru.vyaacheslav.suhov.imeit.interactor.BuildingsInteractor
import ru.vyaacheslav.suhov.imeit.repository.FirebaseRealtimeRepository
import ru.vyaacheslav.suhov.imeit.util.AppConstants.LOG_BUILDINGS

class BuildingsInteractorImpl : BuildingsInteractor {

    private val instance: BuildingsInteractorImpl? = null
    private val repository = FirebaseRealtimeRepository().getInstance()

    /** Создать корпус*/
    override fun createBuildings(eduBuildings: EduBuilding): Single<Boolean> {
        Log.d(LOG_BUILDINGS, "createBuildings")
        return Single.create {
            repository.getRefListEducationBuildings().setValue(eduBuildings)
            it.onSuccess(true)
        }
    }

    /** Получить конкретный корпус*/
    override fun getBuilding(id: String): Single<EduBuilding> {
        Log.d(LOG_BUILDINGS, "getBuilding")
        return Single.create { subscribe ->
            repository.getRefEduBuildingsFromId(id)
                .addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot) {
                        subscribe.onSuccess(p0.getValue(EduBuilding::class.java) ?: EduBuilding())
                    }

                    override fun onCancelled(p0: DatabaseError) {
                        subscribe.onError(Throwable())
                    }
                })

        }
    }

    /** Лист с корпусами*/
    override fun getListBuildings(): Observable<List<EduBuilding>> {
        Log.d(LOG_BUILDINGS, "getListBuildings")
        return Observable.create {
            repository.getRefListEducationBuildings()
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val list = arrayListOf<EduBuilding>()
                        // Все существующие элементы узла
                        for (x: DataSnapshot in snapshot.children) {
                            list.add(x.getValue(EduBuilding::class.java) ?: EduBuilding())
                        }
                        it.onNext(list)
                    }

                    override fun onCancelled(snapshot: DatabaseError) {
                        it.onError(Throwable("cancel"))
                    }
                })
        }
    }

    /** Обновить данные корпуса */
    override fun updateBuilding(id: String, value: EduBuilding): Single<Boolean> {
        Log.d(LOG_BUILDINGS, "updateBuilding")
        return Single.create {
            repository.getRefListEducationBuildings().child(id).setValue(value)
            it.onSuccess(true)
        }
    }

    /** Удалить корпус*/
    override fun deleteBuilding(id: String): Single<Boolean> {
        Log.d(LOG_BUILDINGS, "deleteBuilding")
        return Single.create {
            repository.getRefListEducationBuildings().child(id).removeValue()
            it.onSuccess(true)
        }
    }

    /** Удалить список корпусов */
    override fun deleteBuildingList(): Single<Boolean> {
        Log.d(LOG_BUILDINGS, "deleteBuildingList")
        return Single.create {
            repository.getRefListEducationBuildings().removeValue()
            it.onSuccess(true)
        }
    }

    fun getInstance() = this.instance ?: BuildingsInteractorImpl()
}