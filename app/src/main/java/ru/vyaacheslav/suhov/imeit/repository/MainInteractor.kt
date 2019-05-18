package ru.vyaacheslav.suhov.imeit.repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.repository.entity.MapData
import ru.vyaacheslav.suhov.imeit.repository.entity.Schedule
import ru.vyaacheslav.suhov.imeit.util.Constants.MAX_PAIR
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.util.Constants.CUSTOM

class MainInteractor(val repository: FirebaseRealtimeRepository) {

    /** @return - Список всех корпусов */
    fun getListBuildings(): Observable<ArrayList<MapData>> {
        return Observable.create {
            repository.getRefListEducationBuildings()

                    // Запрос выполниться один раз
                    .addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {

                            val list = arrayListOf<MapData>()

                            // Все существующие элементы узла
                            for (x: DataSnapshot in snapshot.children) {
                                list.add(x.getValue(MapData::class.java) ?: MapData())
                            }
                            it.onNext(list)
                        }

                        override fun onCancelled(snapshot: DatabaseError) {}
                    })
        }
    }

    /** @return - Список всех групп */
    fun getListGroups(institute: String, faculty: String): Observable<ArrayList<String>> {
        return Observable.create {
            repository.getRefListGroups(institute, faculty)
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {

                            val list = arrayListOf("Группа не выбрана")
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
    // Слишком ного параметров | Переделать
    fun getScheduleDay(institute: String, faculty: String, day: String, group: String): Observable<ArrayList<Schedule>> {
        return Observable.create {
            repository.getRefListSchedule(institute, faculty, group, day)
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {

                            val list = ArrayList<Schedule>()
                            for (x in 1..MAX_PAIR) {
                                list.add(snapshot.child("pair$x").getValue(Schedule::class.java)
                                        ?: Schedule()) // <- косяк ("pair$x")
                            }

                            it.onNext(list)
                        }

                        override fun onCancelled(snapshot: DatabaseError) {}
                    })
        }
    }

    /** @return - Стандартные настройки звонков */
    fun getDefaultCallPref(): Observable<CallPref> {
        return Observable.create {
            repository.getRefDefaultPreferencesCall()
                    .addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot) {
                            it.onNext(p0.getValue(CallPref::class.java) ?: CallPref())
                        }

                        override fun onCancelled(p0: DatabaseError) {
                            it.onError(Throwable(p0.toString()))
                        }

                    })
        }
    }

    /** @return - Изменненные установки  звонков*/
    fun getCustomCallPref(): Observable<CallPref> {
        return Observable.create {
            repository.getRefPreferencesCall()
                    .addListenerForSingleValueEvent(object : ValueEventListener {

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
        // В данном случае изменяется конкретный референс и push() не подходит, т.к. ключ создасться за нас
        // push() можно прикрутить для создания списка с локациями

        // Через push() данные добавляются в качестве дочернего элемента

        // Попытка заменить данные. Не получилось
        repository.getRefPreferencesCall().setValue(pref)
        Log.d("TEST", "Interactor: $pref") // Данные отправляются правильные
        //val testPref = CallPref(3,500,20,10,40,2,2)

        // Пробуем так. тоже не робит
        /*  val map = HashMap<String, Any>()
          map[CUSTOM] = pref
          repository.getRefPreferencesCall().updateChildren(map)*/
    }
}