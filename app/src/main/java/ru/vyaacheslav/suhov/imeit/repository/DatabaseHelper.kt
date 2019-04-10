package ru.vyaacheslav.suhov.imeit.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ru.vyaacheslav.suhov.imeit.util.Constants.BELLS
import ru.vyaacheslav.suhov.imeit.util.Constants.GROUPS
import ru.vyaacheslav.suhov.imeit.util.Constants.MAPS

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE $MAPS(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT, locate TEXT);")

        db.execSQL("CREATE TABLE $BELLS(_id INTEGER PRIMARY KEY AUTOINCREMENT, count INTEGER," +
                " start INTEGER, lengthLesson INTEGER, lengthBreak INTEGER,lengthLunch INTEGER," +
                "lengthBreakPair INTEGER, lunchStart INTEGER, date INTEGER, is_changed INTEGER);")

        db.execSQL("CREATE TABLE $GROUPS(_id INTEGER PRIMARY KEY, id_inst INTEGER, " +
                "id_facultet INTEGER, description TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $MAPS")
        db.execSQL("DROP TABLE IF EXISTS $BELLS")
    }

    companion object {
        private const val DB_NAME = "ELSU"
        private const val DB_VERSION = 1
    }
}