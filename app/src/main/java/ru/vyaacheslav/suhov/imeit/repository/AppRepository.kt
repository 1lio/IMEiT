package ru.vyaacheslav.suhov.imeit.repository

import android.content.ContentValues
import android.content.Context
import ru.vyaacheslav.suhov.imeit.repository.entity.MapLocation

class AppRepository(context: Context) {

    private val dbHelper = DatabaseHelper(context).writableDatabase

    fun getListGroup(): Array<String> {

        return arrayOf("Без группы")
    }


    fun addMap(map: MapLocation) {
        val values = ContentValues()
        values.put("name",map.name)
        values.put("address",map.address)
        values.put("locate",map.locate)
        dbHelper.insert("MAPS",null,values)

    }

    fun getMapList(): List<MapLocation> {

        val list: MutableList<MapLocation> = mutableListOf()
        val cursor = dbHelper.rawQuery("SELECT * FROM MAPS", null)

        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            list.add(cursor.position, MapLocation(cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)))
            cursor.moveToNext()
        }
        cursor.close()

        return list
    }
}