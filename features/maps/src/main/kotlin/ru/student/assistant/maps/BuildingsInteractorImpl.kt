package ru.suhov.student.features.gateway

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import io.reactivex.Single
import ru.student.assistant.core.entity.EduLocation
import ru.suhov.student.features.interactor.BuildingsInteractor
import ru.suhov.student.features.repository.FirebaseRealtimeRepository

class BuildingsInteractorImpl : BuildingsInteractor {

    private val instance: BuildingsInteractorImpl? = null
    private val repository = FirebaseRealtimeRepository().getInstance()

    /** Создать корпус*/
    override fun createBuildings(eduBuildings: EduLocation): Single<Boolean> {

        return Single.create {
            repository.getRefListEducationBuildings().setValue(eduBuildings)
            it.onSuccess(true)
        }
    }


    /** Получить конкретный корпус*/
    override fun getBuilding(id: String): Single<EduLocation> {

        return Single.create { subscribe ->
            repository.getRefEduBuildingsFromId(id)
                .addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot) {
                        subscribe.onSuccess(p0.getValue(EduLocation::class.java) ?: EduLocation())
                    }

                    override fun onCancelled(p0: DatabaseError) {
                        subscribe.onError(Throwable())
                    }
                })

        }
    }

    /** Лист с корпусами*/
    override fun getListBuildings(): Observable<List<EduLocation>> {

        return Observable.create {
            repository.getRefListEducationBuildings()
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val list = arrayListOf<EduLocation>()
                        // Все существующие элементы узла
                        for (x: DataSnapshot in snapshot.children) {
                            list.add(x.getValue(EduLocation::class.java) ?: EduLocation())
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
    override fun updateBuilding(id: String, value: EduLocation): Single<Boolean> {
        return Single.create {
            repository.getRefListEducationBuildings().child(id).setValue(value)
            it.onSuccess(true)
        }
    }

    /** Удалить корпус*/
    override fun deleteBuilding(id: String): Single<Boolean> {
        return Single.create {
            repository.getRefListEducationBuildings().child(id).removeValue()
            it.onSuccess(true)
        }
    }

    /** Удалить список корпусов */
    override fun deleteBuildingList(): Single<Boolean> {
        return Single.create {
            repository.getRefListEducationBuildings().removeValue()
            it.onSuccess(true)
        }
    }

    fun getInstance() = this.instance ?: BuildingsInteractorImpl()
}