package ru.vyaacheslav.suhov.imeit.repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.repository.entity.Buildings
import ru.vyaacheslav.suhov.imeit.repository.entity.Schedule
import ru.vyaacheslav.suhov.imeit.util.Constants

class MainInteractor(val repository: FirebaseRealtimeRepository) {

    private val institute: String = "imeit"
    private val faculty: String = "FizMat"


    // Криво создал базу)) Костыльно!
    val getListBuildings: Observable<ArrayList<Buildings>>
        get() = Observable.create {
            repository.getBuildings()
                    .addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(snapshot: DatabaseError) {}

                        override fun onDataChange(snapshot: DataSnapshot) {
                            val list = arrayListOf<Buildings>()
                            for (s: DataSnapshot in snapshot.children) {
                                list.add(Buildings(s.key!!, s.value.toString()))
                            }
                            it.onNext(list)
                        }
                    })
        }



/*
    fun getListGroups(): Observable<ArrayList<String>> {

        return Observable.create {
            repository.getListGroups(faculty, institute)
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
    }

    fun getScheduleDay(day: String, group: String): Observable<ArrayList<Schedule>> {
        return Observable.create {
            repository.getScheduleDay(institute, faculty, "ИСиТ-31", "mon")
                    .addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(snapshot: DataSnapshot) {

                            val list = ArrayList<Schedule>()

                            list.add(snapshot.child("pair1").getValue(Schedule::class.java)
                                    ?: Schedule())


                            */
/*  for (s:DataSnapshot in snapshot.children){
                                  list.add(snapshot.getValue(Schedule::class.java) ?: Schedule())
                              }*//*



                        }

                        override fun onCancelled(snapshot: DatabaseError) {}
                    })
        }
    }

*/

    fun getListGroups(): Observable<ArrayList<String>> {

        return Observable.create {
            repository.getListGroups(institute, faculty)
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
    }

    fun getScheduleDay(day: String, group: String): Observable<ArrayList<Schedule>> {
        return Observable.create {
            repository.getScheduleDay(institute, faculty, group, day)
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {

                            val list = ArrayList<Schedule>()
                        //    list.add(snapshot.child("pair1").getValue(Schedule::class.java) ?: Schedule())

                            for (s:DataSnapshot in snapshot.children){
                                  list.add(snapshot.getValue(Schedule::class.java) ?: Schedule())
                              }
                            Log.d("TESTA2", list.toString())

                        }

                        override fun onCancelled(snapshot: DatabaseError) {}
                    })
        }
    }
}