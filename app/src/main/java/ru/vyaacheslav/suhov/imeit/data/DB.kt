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
            client["address"] = cursor.getString(2)
            client["locate"] = cursor.getString(3)
            clients.add(client)
            cursor.moveToNext()
        }
        cursor.close()

        return clients
    }

    fun dbSchedule(groupe: String, day: String): ArrayList<HashMap<String, Any>> {

        try {
            mDBHelper.updateDataBase()
        } catch (mIOException: IOException) {
            throw Error("UnableToUpdateDatabase")
        }

        val mDb = mDBHelper.writableDatabase
        val times = java.util.ArrayList<java.util.HashMap<String, Any>>()
        var time: java.util.HashMap<String, Any>

        val cursor = mDb.rawQuery("SELECT * FROM $groupe$day", null)
        cursor.moveToFirst()

        while (!cursor.isAfterLast) {
            time = java.util.HashMap()
            // Для UI Обединение клеток
            time["together"] = cursor.getString(1)
            // Числитель
            time["name"] = cursor.getString(2)
            time["surname"] = cursor.getString(3)
            time["type"] = cursor.getString(4)
            time["build"] = cursor.getString(5)
            // Знаменатель
            time["name_out"] = cursor.getString(6)
            time["surname_out"] = cursor.getString(7)
            time["type_out"] = cursor.getString(8)
            time["build_out"] = cursor.getString(9)

            // TODO: Убрать время
            // Время
            time["tex1"] = cursor.getString(10)
            time["tex2"] = cursor.getString(11)
            time["tex3"] = cursor.getString(12)
            times.add(time)
            cursor.moveToNext()
        }
        cursor.close()
        return times

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