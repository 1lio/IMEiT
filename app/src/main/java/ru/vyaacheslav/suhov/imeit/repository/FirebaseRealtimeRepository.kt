package ru.vyaacheslav.suhov.imeit.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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

    fun getInstance() = this.instance ?: FirebaseRealtimeRepository()
}