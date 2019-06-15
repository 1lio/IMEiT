package ru.vyaacheslav.suhov.imeit.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.entity.EduLocation
import ru.vyaacheslav.suhov.imeit.entity.Schedule
import ru.vyaacheslav.suhov.imeit.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.Constants.CUSTOM
import ru.vyaacheslav.suhov.imeit.util.Constants.NOT_SELECT

class MainInteractor(val repository: FirebaseRealtimeRepository) {

    private val localRepository = LocalRepository().getInstance()
    private val institute = localRepository.institute
    private val faculty = localRepository.faculty
    private val group = localRepository.group

    /** @return - Список всех корпусов */
    fun getListBuildings(): Observable<ArrayList<EduLocation>> {
        return Observable.create {
            repository.getRefListEducationBuildings()

                    .addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {

                            val list = arrayListOf<EduLocation>()
                            // Все существующие элементы узла
                            for (x: DataSnapshot in snapshot.children) {
                                list.add(x.getValue(EduLocation::class.java) ?: EduLocation())
                            }
                            it.onNext(list)
                        }

                        override fun onCancelled(snapshot: DatabaseError) {}
                    })
        }
    }

    /** @return - Список всех институтов*/
    fun getListInstitutes(): Observable<ArrayList<String>> {
        return Observable.create {
            repository.getRefInstitutes()
                    .addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError) {}
                        override fun onDataChange(snapshot: DataSnapshot) {

                            val list: ArrayList<String> = arrayListOf(NOT_SELECT)
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
    fun getListFaculty(institute: String): Observable<ArrayList<String>> {
        return  Observable.create {
            repository.getRefFaculty(institute)
                    .addValueEventListener(object :ValueEventListener {

                        override fun onDataChange(snapshot: DataSnapshot) {
                            val list: ArrayList<String> = arrayListOf(NOT_SELECT)
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
    fun getListGroups(institute: String, faculty: String): Observable<ArrayList<String>> {
        return Observable.create {
            repository.getRefListGroups(institute, faculty)
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {

                            val list = arrayListOf(NOT_SELECT)
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
    fun getScheduleDay(day: String): Observable<ArrayList<Schedule>> {
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


    /**@param type - Тип установок DEFAULT или CUSTOM (Пользовательские)
     * @return - Установки  звонков*/
    fun getCallPref(type: String): Observable<CallPref> {
        return Observable.create {
            repository.getRefPreferencesCall(type)
                    .addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot) {
                            it.onNext(p0.getValue(CallPref::class.java) ?: CallPref())
                        }

                        override fun onCancelled(p0: DatabaseError) {
                            it.onError(Throwable(p0.toString()))
                        }
                    })
        }
    }

    /**  Просто отправляем новые установки для звонков
     * @param pref - Установки для передачи */
    fun setCustomCallPref(pref: CallPref) {
        repository.getRefPreferencesCall(CUSTOM).setValue(pref)
    }
}