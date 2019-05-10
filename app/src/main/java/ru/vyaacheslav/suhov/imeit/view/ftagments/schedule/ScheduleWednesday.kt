package ru.vyaacheslav.suhov.imeit.view.ftagments.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.vyaacheslav.suhov.imeit.R

class ScheduleWednesday : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_day, container, false)
    }

/*    private fun connectionDB() {

      //  val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
       // val typeGroup = prefs.getString(getString(R.string.pref_key_group), getString(R.string.pref_key_group))
      //  val schedule = DB(this.context!!).dbSchedule(typeGroup, fr_day)

        recycler.layoutManager = LinearLayoutManager(context)
      //  recycler.adapter = DayFragmentAdapter(schedule)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.setHasFixedSize(true)


    }*/
}