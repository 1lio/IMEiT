package ru.vyaacheslav.suhov.imeit.interactor

import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.entity.Schedule

interface ScheduleInteractor {

    fun getListInstitutes(): Observable<ArrayList<String>>

    fun getListFaculty(institute: String): Observable<ArrayList<String>>

    fun getListGroups(institute: String, faculty: String): Observable<ArrayList<String>>

    fun getScheduleDay(day: String): Observable<ArrayList<Schedule>>
}