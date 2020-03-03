package ru.suhov.student.interactor

import io.reactivex.Observable
import io.reactivex.Single
import ru.suhov.student.entity.EduLocation

interface BuildingsInteractor {

    /** Создать корпус*/
    fun createBuildings(eduBuildings: EduLocation): Single<Boolean>

    /** Получить корпус */
    fun getBuilding(id: String): Single<EduLocation>

    /** Получить список корпусов*/
    fun getListBuildings(): Observable<List<EduLocation>>

    /** Обновить здание */
    fun updateBuilding(id: String, value: EduLocation): Single<Boolean>

    /** Удалить здание */
    fun deleteBuilding(id: String): Single<Boolean>

    /** Удалить список со всеми зданиями */
    fun deleteBuildingList(): Single<Boolean>
}