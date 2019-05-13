package ru.vyaacheslav.suhov.imeit.repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.repository.entity.Buildings
import ru.vyaacheslav.suhov.imeit.repository.entity.Schedule

class MainInteractor(val repository: FirebaseRealtimeRepository) {

    private val institute: String = "imeit"
    private val faculty: String = "FizMat"

    fun getListBuildings(): Observable<ArrayList<Buildings>> =
            Observable.create {
                repository.getBuildings()
                        .addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val list = arrayListOf<Buildings>()
                                for (s: DataSnapshot in snapshot.children) {
                                    list.add(Buildings(s.key!!, s.value.toString())) }
                                it.onNext(list)
                            }
                            override fun onCancelled(snapshot: DatabaseError) {}
                        })
            }

    fun getListGroups(): Observable<ArrayList<String>> =
            Observable.create {
                repository.getListGroups(institute, faculty)
                        .addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val list = arrayListOf("Группа не выбрана")
                                for (s: DataSnapshot in snapshot.children) { list.add(s.key!!) }
                                it.onNext(list)
                            }
                            override fun onCancelled(snapshot: DatabaseError) {}
                        })

            }

    fun getScheduleDay(day: String, group: String): Observable<ArrayList<Schedule>> =
            Observable.create {
                repository.getScheduleDay(institute, faculty, group, day)
                        .addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {

                                // TODO: ПЕРЕДЕЛАТЬ!
                                val list = ArrayList<Schedule>()
                                if (list.size > 3) list.clear()
                                list.add(snapshot.child("pair1").getValue(Schedule::class.java) ?: Schedule())
                                list.add(snapshot.child("pair2").getValue(Schedule::class.java) ?: Schedule())
                                list.add(snapshot.child("pair3").getValue(Schedule::class.java) ?: Schedule())
                                list.add(snapshot.child("pair4").getValue(Schedule::class.java) ?: Schedule())

                                it.onNext(list)

                           Log.d("TESTA:Interactor", list.toString())
                            }

                            override fun onCancelled(snapshot: DatabaseError) {}
                        })
            }
}