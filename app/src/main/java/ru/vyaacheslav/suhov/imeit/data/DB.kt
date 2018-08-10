package ru.vyaacheslav.suhov.imeit.data

import android.content.Context
import java.io.IOException

class DB(context: Context) {

    private val mDBHelper = DatabaseHelper(context)

    fun dbMaps(): ArrayList<HashMap<String, Any>> {
        try {
            mDBHelper.updateDataBase()
        } catch (mIOException: IOException) {
            throw Error("UnableToUpdateDatabase")
        }
        val mDb = mDBHelper.writableDatabase
        val clients = ArrayList<HashMap<String, Any>>()
        var client: HashMap<String, Any>

        val cursor = mDb.rawQuery("SELECT * FROM MAPS", null)
        cursor.moveToFirst()

        while (!cursor.isAfterLast) {
            client = HashMap()
            client["name"] = cursor.getString(1)
            client["addres"] = cursor.getString(2)
            clients.add(client)
            cursor.moveToNext()
        }
        cursor.close()

        return clients
    }

    fun dbTimes(): ArrayList<HashMap<String, Any>> {

        try {
            mDBHelper.updateDataBase()
        } catch (mIOException: IOException) {
            throw Error("UnableToUpdateDatabase")
        }

        val mDb = mDBHelper.writableDatabase
        val lessons = java.util.ArrayList<java.util.HashMap<String, Any>>()
        var less: java.util.HashMap<String, Any>

        val cursor = mDb.rawQuery("SELECT * FROM LESSON", null)
        cursor.moveToFirst()

        while (!cursor.isAfterLast) {
            less = java.util.HashMap()
            less["_id"] = cursor.getString(0)
            less["time_top"] = cursor.getString(1)
            less["time_out"] = cursor.getString(2)
            less["pre_top"] = cursor.getString(3)
            less["pre_out"] = cursor.getString(4)
            lessons.add(less)
            cursor.moveToNext()
        }
        cursor.close()

        return lessons
    }
}