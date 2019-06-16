package ru.vyaacheslav.suhov.imeit.interactor

import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.entity.Schedule

interface ScheduleInteractor {

    /** @return - Список всех институтов*/
    fun getListInstitutes(): Observable<ArrayList<String>>

    /** @param institute - необходимо указать родительский институт
     *  @return - Список всех факультетов данного института */
    fun getListFaculty(institute: String): Observable<ArrayList<String>>

    /**@return - Список всех групп */
    fun getListGroups(institute: String, faculty: String): Observable<ArrayList<String>>

    /** @param day - день недели
     * @return - Список в парами к текущему дню */
    fun getScheduleDay(day: String): Observable<ArrayList<Schedule>>
}