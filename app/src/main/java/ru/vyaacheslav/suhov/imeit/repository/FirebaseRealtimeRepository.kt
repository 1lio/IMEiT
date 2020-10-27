package ru.vyaacheslav.suhov.imeit.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ru.vyaacheslav.suhov.imeit.util.Constants.CALL_REFERENCE
import ru.vyaacheslav.suhov.imeit.util.Constants.FACULTY
import ru.vyaacheslav.suhov.imeit.util.Constants.GROUPS
import ru.vyaacheslav.suhov.imeit.util.Constants.INSTITUTES
import ru.vyaacheslav.suhov.imeit.util.Constants.MAP_REFERENCE
import ru.vyaacheslav.suhov.imeit.util.Constants.USER_REFERENCE

class FirebaseRealtimeRepository {

    private val instance: FirebaseRealtimeRepository? = null
    private val database = FirebaseDatabase.getInstance()


    fun getRefListEducationBuildings() = database.getReference(MAP_REFERENCE)

    fun getRefEduBuildingsFromId(id:String) = database.getReference(MAP_REFERENCE).child(id)


    fun getRefInstitutes(): DatabaseReference {
        return FirebaseDatabase.getInstance()
                .getReference(INSTITUTES)
    }

    fun getRefFaculty(institute: String): DatabaseReference {
        return FirebaseDatabase.getInstance()
                .getReference(INSTITUTES).child(institute)
                .child(FACULTY)
    }

    fun getRefListGroups(institute: String, faculty: String): DatabaseReference {
        return FirebaseDatabase.getInstance()
                .getReference(INSTITUTES).child(institute)
                .child(FACULTY).child(faculty)
                .child(GROUPS)
    }

    fun getRefListSchedule(institute: String, faculty: String, group: String, day: String): DatabaseReference {
        return FirebaseDatabase.getInstance()
                .getReference(INSTITUTES).child(institute)
                .child(FACULTY).child(faculty)
                .child(GROUPS).child(group)
                .child(day)
    }

    fun getRefPreferencesCall(type: String): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(CALL_REFERENCE).child(type)
    }

    fun getRefUser(userId: String): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(USER_REFERENCE).child(userId)
    }

    fun getInstance() = this.instance ?: FirebaseRealtimeRepository()
}