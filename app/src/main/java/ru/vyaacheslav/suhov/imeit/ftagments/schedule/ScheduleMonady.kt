package ru.vyaacheslav.suhov.imeit.ftagments.schedule

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.data.DB

class ScheduleMonady : Fragment() {
    lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.monday, container, false)
        listView = v.findViewById(R.id.schedule_list)

        connectionDB()
        return v
    }

    private fun connectionDB() {

        val lessons = DB(this.context!!).dbTimeSchedule()
        val from = arrayOf("text1", "text2", "text3")
        val to = intArrayOf(R.id.tex1, R.id.tex2, R.id.tex3)

        val adapter = SimpleAdapter(activity, lessons, R.layout.item_schedule, from, to)
        listView.adapter = adapter
    }
}