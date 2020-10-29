package ru.student.assistant.repo.schedule

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import io.reactivex.Single
import ru.student.assistant.core.Constants
import ru.student.assistant.core.entity.Schedule

import java.lang.Exception

class ScheduleInteractorImpl : ScheduleInteractor {

    private val instance: ScheduleInteractorImpl? = null
    private val localRepository = LocalRepository().getInstance()
    private val repository = FirebaseRealtimeRepository().getInstance()

    private val institute = localRepository.institute
    private val faculty = localRepository.faculty
    private val group = localRepository.group


    /** @return - Список всех институтов*/
    override fun getListInstitutes(): Observable<ArrayList<String>> {
        return Observable.create {
            repository.getRefInstitutes()
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {}
                    override fun onDataChange(snapshot: DataSnapshot) {

                        val list: ArrayList<String> = arrayListOf(Constants.NOT_SELECT)
                        for (s: DataSnapshot in snapshot.children) {
                            list.add(s.key.toString()) // Список по ключам!
                        }
                        it.onNext(list)
                    }
                })
        }
    }

    /** @param institute - необходимо указать родительский институт
     *  @return - Список всех факультетов данного института */
    override fun getListFaculty(institute: String): Observable<ArrayList<String>> {
        return Observable.create {
            repository.getRefFaculty(institute)
                .addValueEventListener(object : ValueEventListener {

                    override fun onDataChange(snapshot: DataSnapshot) {
                        val list: ArrayList<String> = arrayListOf(Constants.NOT_SELECT)
                        for (s: DataSnapshot in snapshot.children) {
                            list.add(s.key.toString())
                        }
                        it.onNext(list)
                    }

                    override fun onCancelled(p0: DatabaseError) {}
                })
        }
    }

    /** @return - Список всех групп */
    override fun getListGroups(institute: String, faculty: String): Observable<ArrayList<String>> {
        return Observable.create {
            repository.getRefListGroups(institute, faculty)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {

                        val list = arrayListOf(Constants.NOT_SELECT)
                        for (s: DataSnapshot in snapshot.children) {
                            list.add(s.key.toString()) // Список по ключам!
                        }
                        it.onNext(list)
                    }

                    override fun onCancelled(snapshot: DatabaseError) {}
                })
        }
    }

    /** @return - Список в парами к текущему дню */
    override fun getScheduleDay(day: String): Observable<ArrayList<Schedule>> {
        return Observable.create {
            repository.getRefListSchedule(institute, faculty, group, day)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {

                        val list = ArrayList<Schedule>()
                        for (x in 1..localRepository.countPair) {
                            list.add(
                                snapshot.child("pair$x").getValue(Schedule::class.java)
                                    ?: Schedule()
                            )
                        }
                        it.onNext(list)
                    }

                    override fun onCancelled(snapshot: DatabaseError) {}
                })
        }
    }


    override fun updateDaySchedule(day: String, schedule: Schedule): Single<Boolean> {

        return Single.create {

            repository.updateDay(day)

        }
    }

    override fun createSchedule(
        institute: String,
        faculty: String,
        day: String,
        pair: String,
        schedule: Schedule
    ): Single<Boolean> {
        return Single.create {
            it.onSuccess(true)
            it.onError(Exception("error"))
        }
    }


    override fun deleteSchedule(id: String): Single<Boolean> {
        return Single.create {
            it.onSuccess(true)
            it.onError(Exception("error"))
        }
    }

    fun getInstance() = this.instance ?: ScheduleInteractorImpl()
}