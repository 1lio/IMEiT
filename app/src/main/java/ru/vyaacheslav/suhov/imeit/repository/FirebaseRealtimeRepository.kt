package ru.vyaacheslav.suhov.imeit.repository

import com.google.firebase.database.FirebaseDatabase
import ru.vyaacheslav.suhov.imeit.util.Constants
import ru.vyaacheslav.suhov.imeit.util.Constants.MAP_REFERENCE

class FirebaseRealtimeRepository {

    private val instance: FirebaseRealtimeRepository? = null

    //RETURNS References
    fun getBuildings() = FirebaseDatabase.getInstance().getReference(MAP_REFERENCE)

    fun getListGroups(institute: String, faculty: String) =
            FirebaseDatabase.getInstance().getReference(Constants.INSTITUTES)
                    .child(institute).child(Constants.FACULTY).child(faculty).child(Constants.GROUPS)

    fun getScheduleDay(institute: String, faculty: String, group: String, day: String) =
            FirebaseDatabase.getInstance().getReference(Constants.INSTITUTES).child(institute)
                    .child(Constants.FACULTY).child(faculty).child(Constants.GROUPS).child(group)
                    .child(day)

    fun getInstance() = this.instance ?: FirebaseRealtimeRepository()
}