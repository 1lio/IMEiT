package ru.vyaacheslav.suhov.imeit.interactor

import io.reactivex.Observable
import io.reactivex.Single
import ru.vyaacheslav.suhov.imeit.entity.EduBuilding

interface BuildingsInteractor {

    fun createBuildings(eduBuildings: EduBuilding):Single<Boolean>

    fun getBuilding(id: String): Single<EduBuilding>

    fun getListBuildings():Observable<List<EduBuilding>>

    fun updateBuilding(id: String, value: EduBuilding): Single<Boolean>

    fun deleteBuilding(id:String):Single<Boolean>

    fun deleteBuildingList():Single<Boolean>
}