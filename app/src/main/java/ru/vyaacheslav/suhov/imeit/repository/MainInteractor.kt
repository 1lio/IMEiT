package ru.vyaacheslav.suhov.imeit.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.repository.entity.Buildings
import ru.vyaacheslav.suhov.imeit.repository.entity.Schedule

class MainInteractor(val repository: FirebaseRealtimeRepository) {

    fun getListBuildings(): Observable<ArrayList<Buildings>> {

        return Observable.create {
            repository.getRefListEducationBuildings()
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            val list = arrayListOf<Buildings>()
                            for (s: DataSnapshot in snapshot.children) {
                                list.add(Buildings(s.key!!, s.value.toString()))
                            }
                            it.onNext(list)
                        }
                        override fun onCancelled(snapshot: DatabaseError) {}
                    })
        }
    }

    fun getListGroups(institute: String, faculty: String): Observable<ArrayList<String>> =
            Observable.create {
                repository.getRefListGroups(institute, faculty)
                        .addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val list = arrayListOf("Группа не выбрана")
                                for (s: DataSnapshot in snapshot.children) {
                                    list.add(s.key!!)
                                }
                                it.onNext(list)
                            }

                            override fun onCancelled(snapshot: DatabaseError) {}
                        })

            }

    fun getScheduleDay(institute: String, faculty: String, day: String, group: String): Observable<ArrayList<Schedule>> =
            Observable.create {
                repository.getRefListSchedule(institute, faculty, group, day)
                        .addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {

                                val list = ArrayList<Schedule>()

                                for (x in 1..4) {
                                    list.add(snapshot.child("pair$x").getValue(Schedule::class.java) ?: Schedule())
                                }

                                it.onNext(list)
                            }

                            override fun onCancelled(snapshot: DatabaseError) {}
                        })
            }
}