package ru.vyaacheslav.suhov.imeit.repository

import android.content.Context
import ru.vyaacheslav.suhov.imeit.repository.entity.BellData

class DB(context: Context) {

    private val mDBHelper = DatabaseHelper(context)

    fun dbMaps(): ArrayList<HashMap<String, Any>> {

        val clients = ArrayList<HashMap<String, Any>>()
        var client: HashMap<String, Any>

        val cursor = mDBHelper.writableDatabase.rawQuery("SELECT * FROM MAPS", null)

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

    fun dbSchedule(group: String, day: String): ArrayList<HashMap<String, Any>> {

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
            time["nameOut"] = cursor.getString(6)
            time["surnameOut"] = cursor.getString(7)
            time["typeOut"] = cursor.getString(8)
            time["buildOut"] = cursor.getString(9)

            times.add(time)
            cursor.moveToNext()
        }
        cursor.close()
        return times

    }

    /** @see dbBellsSettings - Функция берет из базы таблицу и формирует список
     *  @return Список настройками для формирования расписания звонков */

    fun dbBellsSettings(nameBellTable: String = "BELLS"): List<BellData> {

        val mDb = mDBHelper.writableDatabase
        val cursor = mDb.rawQuery("SELECT * FROM $nameBellTable", null)

        val listBell: MutableList<BellData> = mutableListOf()
        cursor.moveToFirst()

        for (x in 0..4) {
            if (!cursor.isAfterLast) {
                listBell.add(BellData(cursor.getInt(x)))
                cursor.moveToNext()
            }
        }
        cursor.close()
        return listBell
    }
}