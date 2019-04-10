package ru.vyaacheslav.suhov.imeit.view.ftagments.schedule

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.day.*
import ru.vyaacheslav.suhov.imeit.R

class ScheduleWedneday : androidx.fragment.app.Fragment() {

    private val day: String = "WEN"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.day, container, false)

       // connectionDB()
        return v
    }

    private fun connectionDB() {

        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
       // val typeGroup = prefs.getString(getString(R.string.pref_key_group), getString(R.string.pref_key_group))
      //  val schedule = DB(this.context!!).dbSchedule(typeGroup, day)

        recycler.layoutManager = LinearLayoutManager(context)
      //  recycler.adapter = DayAdapter(schedule)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.setHasFixedSize(true)


    }
}