package ru.vyaacheslav.suhov.imeit.data

import android.content.Context
import core.objects.BellCount
import core.objects.BellSetup
import java.io.IOException

class DB(context: Context?) {

    private val mDBHelper = DatabaseHelper(context)
    //TODO: ГОВНОКОД
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
    //TODO: ГОВНОКОД
    fun dbSchedule(group: String, day: String): ArrayList<HashMap<String, Any>> {

        try {
            mDBHelper.updateDataBase()
        } catch (mIOException: IOException) {
            throw Error("UnableToUpdateDatabase")
        }

        val mDb = mDBHelper.writableDatabase
        val times = java.util.ArrayList<java.util.HashMap<String, Any>>()
        var time: java.util.HashMap<String, Any>

        val cursor = mDb.rawQuery("SELECT * FROM $group$day", null)
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


    /** @see dbTimes - Функция берет из базы таблицу и формирует список
     * @return Список */

    fun dbTimes(nameBellTable: String = "BELLS"): List<BellSetup> {

        val mDb = mDBHelper.writableDatabase
        val cursor = mDb.rawQuery("SELECT * FROM $nameBellTable", null)

        val listBell: MutableList<BellSetup> = mutableListOf()
        cursor.moveToFirst()

        for (x in 0..9) {
            if (!cursor.isAfterLast) {
                val bellsTable = BellSetup(cursor.getInt(x))
                listBell.add(bellsTable)
                cursor.moveToNext()
            }
        }
        cursor.close()
        return listBell
    }
}