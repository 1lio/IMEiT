package ru.vyaacheslav.suhov.imeit.repository

import com.orhanobut.hawk.Hawk
import ru.vyaacheslav.suhov.imeit.repository.entity.MapLocation
import ru.vyaacheslav.suhov.imeit.util.AppConfig.KEY_GROUP
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_GROUP

class AppRepository {

    // private val dbHelper = DatabaseHelper(context).writableDatabase

    fun getListGroup(): Array<String> {

        return arrayOf("Без группы","ИиВТ-11")
    }

    fun getGroupId(): Int {

        val list = getListGroup()

        var id = 0
        for (i in 0..list.size) {
            if (Hawk.get(KEY_GROUP, DEF_GROUP) == list[id]) {
                id = i
                break
            }
        }
        return id

    }

    /* fun addMap(map: MapLocation) {
         val values = ContentValues()
         values.put("name",map.name)
         values.put("address",map.address)
         values.put("locate",map.locate)
         dbHelper.insert("MAPS",null,values)

     }*/

    fun getMapList(): List<MapLocation> {

        val list: MutableList<MapLocation> = mutableListOf()
        /*   val cursor = dbHelper.rawQuery("SELECT * FROM MAPS", null)

           cursor.moveToFirst()
           while (!cursor.isAfterLast) {
               list.add(cursor.position, MapLocation(cursor.getString(1),
                       cursor.getString(2),
                       cursor.getString(3)))
               cursor.moveToNext()
           }
           cursor.close()*/

        return list
    }
}