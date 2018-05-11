package ru.vyaacheslav.suhov.imeit.ftagments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import ru.vyaacheslav.suhov.imeit.R
import java.io.IOException
import java.util.*

class Session : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_exzam, container, false)
        val mDBHelper = DatabaseHelper(activity)

        try {
            mDBHelper.updateDataBase()
        } catch (mIOException: IOException) {
            throw Error("UnableToUpdateDatabase")
        }

        val mDb = mDBHelper.writableDatabase
        val clients = ArrayList<HashMap<String, Any>>()
        var client: HashMap<String, Any>

        val cursor = mDb.rawQuery("SELECT * FROM FMiI11", null)
        cursor.moveToFirst()

        while (!cursor.isAfterLast) {
            client = HashMap()
            client["name"] = cursor.getString(1)
            client["age"] = cursor.getString(2)
            clients.add(client)
            cursor.moveToNext()
        }
        cursor.close()

        val from = arrayOf("name", "age")
        val to = intArrayOf(R.id.tex1, R.id.tex2)

        val adapter = SimpleAdapter(activity, clients, R.layout.custom_list, from, to)
        val listView = v.findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

        return v
    }
}