package ru.vyaacheslav.suhov.imeit.gateway

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import io.reactivex.Single
import ru.vyaacheslav.suhov.imeit.entity.EduBuilding
import ru.vyaacheslav.suhov.imeit.interactor.BuildingsInteractor
import ru.vyaacheslav.suhov.imeit.repository.FirebaseRealtimeRepository

class BuildingsInteractorImpl : BuildingsInteractor {

    private val instance: BuildingsInteractorImpl? = null
    private val repository = FirebaseRealtimeRepository().getInstance()

    override fun createBuildings(eduBuildings: EduBuilding): Single<Boolean> {
        return Single.create {
            repository.getRefListEducationBuildings().setValue(eduBuildings)
            it.onSuccess(true)
        }
    }

    override fun getBuilding(id: String): Single<EduBuilding> {
        return Single.create { subscribe ->
            repository.getRefEduBuildingsFromId(id).addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    subscribe.onSuccess(p0.getValue(EduBuilding::class.java) ?: EduBuilding())
                }

                override fun onCancelled(p0: DatabaseError) {
                    subscribe.onError(Throwable())
                }
            })

        }
    }

    override fun getListBuildings(): Observable<List<EduBuilding>> {
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

    override fun updateBuilding(id: String, value: EduBuilding): Single<Boolean> {
        return Single.create {
            repository.getRefListEducationBuildings().child(id).setValue(value)
            it.onSuccess(true)
        }
    }

    override fun deleteBuilding(id: String): Single<Boolean> {
        return Single.create {
            repository.getRefListEducationBuildings().child(id).removeValue()
            it.onSuccess(true)
        }
    }

    override fun deleteBuildingList(): Single<Boolean> {
        return Single.create {
            repository.getRefListEducationBuildings().removeValue()
            it.onSuccess(true)
        }
    }

    fun getInstance() = this.instance ?:BuildingsInteractorImpl()
}