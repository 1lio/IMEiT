package ru.suhov.student.features.interactor

import io.reactivex.Observable
import io.reactivex.Single
import ru.student.core.entity.Schedule

interface ScheduleInteractor {

    /** @return - Список всех институтов*/
    fun getListInstitutes(): Observable<ArrayList<String>>

    /** @param institute - необходимо указать родительский институт
     *  @return - Список всех факультетов данного института */
    fun getListFaculty(institute: String): Observable<ArrayList<String>>

    /**@return - Список всех групп */
    fun getListGroups(institute: String, faculty: String): Observable<ArrayList<String>>

    /** Создать расписание для данной группы */
    fun createSchedule(
        institute: String,
        faculty: String,
        day: String,
        pair: String,
        schedule: Schedule
    ): Single<Boolean>

    /** @param day - день недели
     * @return - Список в парами к текущему дню */
    fun getScheduleDay(day: String): Observable<ArrayList<Schedule>>

    /** Обновить расписание для выбранного дня */
    fun updateDaySchedule(day: String, schedule: Schedule): Single<Boolean>

    /** Удалить расписание */
    fun deleteSchedule(id: String): Single<Boolean>

}