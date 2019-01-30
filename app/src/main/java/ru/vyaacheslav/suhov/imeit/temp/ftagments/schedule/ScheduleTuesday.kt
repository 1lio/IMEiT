package ru.vyaacheslav.suhov.imeit.temp.ftagments.schedule

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.temp.data.DB

class ScheduleTuesday : Fragment() {

    private lateinit var listView: ListView
    private val day: String = "TUE"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.monday, container, false)
        listView = v.findViewById(R.id.schedule_list)

        connectionDB()
        return v
    }

    private fun connectionDB() {

        val typeGroupe: String
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        typeGroupe = prefs.getString(getString(R.string.pref_key_group), "")
        val schedule = DB(this.context!!).dbSchedule(typeGroupe, day)

        val fromS = arrayOf("name", "surname", "type", "build",
                "name_out", "surname_out", "type_out", "build_out", "tex1", "tex2", "tex3")

        val toS = intArrayOf(R.id.s_name, R.id.s_subname, R.id.s_type, R.id.s_build,
                R.id.s_name_d, R.id.s_subname_d, R.id.s_type_d, R.id.s_build_d, R.id.tex1, R.id.tex2, R.id.tex3)

        val adapter2 = SimpleAdapter(activity, schedule, R.layout.item_schedule, fromS, toS)

        listView.adapter = adapter2
    }
}