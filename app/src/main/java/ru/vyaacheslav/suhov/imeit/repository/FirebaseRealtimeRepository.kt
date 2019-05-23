package ru.vyaacheslav.suhov.imeit.repository

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ru.vyaacheslav.suhov.imeit.util.Constants.CALL_REFERENCE
import ru.vyaacheslav.suhov.imeit.util.Constants.FACULTY
import ru.vyaacheslav.suhov.imeit.util.Constants.GROUPS
import ru.vyaacheslav.suhov.imeit.util.Constants.INSTITUTES
import ru.vyaacheslav.suhov.imeit.util.Constants.MAP_REFERENCE

class FirebaseRealtimeRepository {

    private val instance: FirebaseRealtimeRepository? = null

    /** @see getRefListEducationBuildings
     *  @return Reference на список всех корпусов*/

    fun getRefListEducationBuildings() = FirebaseDatabase.getInstance().getReference(MAP_REFERENCE)

    /** @see getRefListGroups
     *  @param institute - Текущий институт
     *  @param faculty - Факультет
     *  @return Список всех групп данного института/факультета */

    fun getRefListGroups(institute: String, faculty: String): DatabaseReference {
        return FirebaseDatabase.getInstance()
                .getReference(INSTITUTES).child(institute)
                .child(FACULTY).child(faculty)
                .child(GROUPS)
    }

    /** @see getRefListSchedule
     *  @param institute - Текущий институт
     *  @param faculty - Факультет
     *  @param group - Группа
     *  @param day - День
     *  @return Array<Schedule> | Спиок с расписанием */

    fun getRefListSchedule(institute: String, faculty: String, group: String, day: String): DatabaseReference {
        return FirebaseDatabase.getInstance()
                .getReference(INSTITUTES).child(institute)
                .child(FACULTY).child(faculty)
                .child(GROUPS).child(group)
                .child(day)
    }

    /** @return Настройки для звонков */
    fun getRefPreferencesCall(type:String):DatabaseReference{
        Log.d("TESTA", "${FirebaseDatabase.getInstance().getReference(CALL_REFERENCE).child(type)}")
        return FirebaseDatabase.getInstance().getReference(CALL_REFERENCE).child(type)
    }

    fun getInstance() = this.instance ?: FirebaseRealtimeRepository()
}