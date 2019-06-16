package ru.vyaacheslav.suhov.imeit.interactor

import io.reactivex.Observable
import io.reactivex.Single
import ru.vyaacheslav.suhov.imeit.entity.EduBuilding

interface BuildingsInteractor {

    /** Создать корпус*/
    fun createBuildings(eduBuildings: EduBuilding):Single<Boolean>

    /** Получить корпус */
    fun getBuilding(id: String): Single<EduBuilding>

    /** Получить список корпусов*/
    fun getListBuildings():Observable<List<EduBuilding>>

    /** Обновить здание */
    fun updateBuilding(id: String, value: EduBuilding): Single<Boolean>

    /** Удалить здание */
    fun deleteBuilding(id:String):Single<Boolean>

    /** Удалить список со всеми зданиями */
    fun deleteBuildingList():Single<Boolean>
}