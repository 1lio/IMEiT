package ru.vyaacheslav.suhov.imeit.view.ftagments.schedule

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import kotlinx.android.synthetic.main.fr_day.*
import ru.vyaacheslav.suhov.imeit.R

class ScheduleTuesday : androidx.fragment.app.Fragment() {

    private lateinit var listView: ListView
    private val day: String = "TUE"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fr_day, container, false)

        //connectionDB()
        return v
    }

    private fun connectionDB() {

        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
       // val typeGroup = prefs.getString(getString(R.string.pref_key_group), getString(R.string.pref_key_group))
      //  val schedule = DB(this.context!!).dbSchedule(typeGroup, fr_day)

        recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
      //  recycler.adapter = DayFragmentAdapter(schedule)
        recycler.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recycler.setHasFixedSize(true)
    }
}