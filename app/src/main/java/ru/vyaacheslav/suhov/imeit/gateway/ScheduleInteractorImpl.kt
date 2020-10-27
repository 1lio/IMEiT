package ru.vyaacheslav.suhov.imeit.gateway

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.entity.Schedule
import ru.vyaacheslav.suhov.imeit.interactor.ScheduleInteractor
import ru.vyaacheslav.suhov.imeit.repository.FirebaseRealtimeRepository
import ru.vyaacheslav.suhov.imeit.repository.LocalRepository
import ru.vyaacheslav.suhov.imeit.util.Constants

class ScheduleInteractorImpl : ScheduleInteractor {

    private val instance: ScheduleInteractorImpl? = null

    private val localRepository = LocalRepository().getInstance()
    private val institute = localRepository.institute
    private val faculty = localRepository.faculty
    private val group = localRepository.group

    private val repository = FirebaseRealtimeRepository().getInstance()

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

    override fun getScheduleDay(day: String): Observable<ArrayList<Schedule>> {
        return Observable.create {
            repository.getRefListSchedule(institute, faculty, group, day)
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {

                            val list = ArrayList<Schedule>()
                            for (x in 1..localRepository.countPair) {
                                list.add(snapshot.child("pair$x").getValue(Schedule::class.java)
                                        ?: Schedule())
                            }
                            it.onNext(list)
                        }

                        override fun onCancelled(snapshot: DatabaseError) {}
                    })
        }
    }

    fun getInstance() = this.instance ?: ScheduleInteractorImpl()

}