package ru.vyaacheslav.suhov.imeit.ftagments

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R
import java.io.IOException
import java.lang.Exception

class Session : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_exzam, container, false)

        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)

        val position = prefs.getString(getString(R.string.pref_groupe), "")
        val mDBHelper = DatabaseHelper(activity)

        try {
            mDBHelper.updateDataBase()
        } catch (mIOException: IOException) {
            throw Error("UnableToUpdateDatabase")
        }

        val mDb = mDBHelper.writableDatabase
        val clients = ArrayList<HashMap<String, Any>>()
        var client: HashMap<String, Any>
        val listView = v.findViewById<ListView>(R.id.listView)
        val examInf: TextView = v.findViewById(R.id.exam_inf)

        try {
            val cursor = mDb.rawQuery("SELECT * FROM $position", null)
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                client = HashMap()
                client["name"] = cursor.getString(1)
                client["type"] = cursor.getString(2)
                client["time"] = cursor.getString(3)
                client["build"] = cursor.getString(4)
                client["date"] = cursor.getString(5)
                clients.add(client)
                cursor.moveToNext()
            }
            cursor.close()

            val from = arrayOf("name", "type", "time", "build", "date")
            val to = intArrayOf(R.id.tex1, R.id.tex2, R.id.tex3, R.id.tex4, R.id.tex5)
            val adapter = SimpleAdapter(activity, clients, R.layout.custom_list, from, to)
            listView.adapter = adapter

        } catch (e: Exception) {
            listView.visibility = View.GONE
            examInf.text = "По вашей группе нет информации"
            examInf.setBackgroundColor(resources.getColor(R.color.colorExam))
        }
        return v
    }
}