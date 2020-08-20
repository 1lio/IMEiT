package ru.student.assistant.calls.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ru.student.core.Constants.CALL_REFERENCE
import ru.student.core.Constants.FACULTY
import ru.student.core.Constants.GROUPS
import ru.student.core.Constants.INSTITUTES
import ru.student.core.Constants.MAP_REFERENCE
import ru.student.core.Constants.USER_REFERENCE

class FirebaseRealtimeRepository {

    private val instance: FirebaseRealtimeRepository? = null
    private val database = FirebaseDatabase.getInstance()

    /** @see getRefListEducationBuildings
     *  @return Reference на список всех корпусов*/
    fun getRefListEducationBuildings() = database.getReference(MAP_REFERENCE)

    fun getRefEduBuildingsFromId(id: String) = database.getReference(MAP_REFERENCE).child(id)

    /** Референс на институты*/
    fun getRefInstitutes(): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(INSTITUTES)
    }

    /** @param institute - Родительский институт
     *  @return Референс на факультеты */

    fun getRefFaculty(institute: String): DatabaseReference {
        return FirebaseDatabase.getInstance()
            .getReference(INSTITUTES).child(institute)
            .child(FACULTY)
    }

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

    /** @return Настройки для звонков */
    fun getRefPreferencesCall(type: String): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(CALL_REFERENCE).child(type)
    }

    /** @return Данные пользователя */
    fun getRefUser(userId: String): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(USER_REFERENCE).child(userId)
    }

    /** @see getRefListSchedule
     *  @param institute - Текущий институт
     *  @param faculty - Факультет
     *  @param group - Группа
     *  @param day - День
     *  @return Array<Schedule> | Спиок с расписанием */
    fun getRefListSchedule(
        institute: String,
        faculty: String,
        group: String,
        day: String
    ): DatabaseReference {
        return FirebaseDatabase.getInstance()
            .getReference(INSTITUTES).child(institute)
            .child(FACULTY).child(faculty)
            .child(GROUPS).child(group)
            .child(day)
    }

    fun updateDay(day: String): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(day)

    }

    fun getInstance() = this.instance ?: FirebaseRealtimeRepository()
}