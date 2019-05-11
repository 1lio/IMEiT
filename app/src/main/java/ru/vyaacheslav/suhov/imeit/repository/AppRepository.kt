package ru.vyaacheslav.suhov.imeit.repository

import android.util.Log
import com.google.firebase.database.*
import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.repository.entity.Schedule
import ru.vyaacheslav.suhov.imeit.util.Constants.FACULTY
import ru.vyaacheslav.suhov.imeit.util.Constants.GROUPS
import ru.vyaacheslav.suhov.imeit.util.Constants.INSTITUTES

class AppRepository {

    private val db = FirebaseDatabase.getInstance()

    private val institute: String = "imeit"
    private val faculty: String = "FizMat"

    fun getListGroups(): Observable<ArrayList<String>> {

        return Observable.create {
            db.getReference(INSTITUTES).child(institute).child(FACULTY).child(faculty).child(GROUPS)
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
            db.getReference(INSTITUTES).child(institute).child(FACULTY).child(faculty).child(GROUPS).child(group).child("mon")
                    .addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(snapshot: DataSnapshot) {

                            val list = ArrayList<Schedule>()

                           list.add(snapshot.child("pair1").getValue(Schedule::class.java) ?: Schedule())


                           /*  for (s:DataSnapshot in snapshot.children){
                                 list.add(snapshot.getValue(Schedule::class.java) ?: Schedule())
                             }*/
                            Log.d("TESTA2", list.toString())

                        }

                        override fun onCancelled(snapshot: DatabaseError) {}
                    })
        }
    }
}