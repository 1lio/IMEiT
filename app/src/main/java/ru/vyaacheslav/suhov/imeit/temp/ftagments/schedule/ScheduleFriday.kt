package ru.vyaacheslav.suhov.imeit.temp.ftagments.schedule

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.monday.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.temp.adapters.DayAdapter
import ru.vyaacheslav.suhov.imeit.temp.data.DB

class ScheduleFriday : androidx.fragment.app.Fragment() {

    private val day: String = "FRI"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.monday, container, false)


        connectionDB()
        return v
    }
        private fun connectionDB() {

            val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
            //val typeGroup = prefs.getString(getString(R.string.pref_key_group), getString(R.string.pref_key_group))
          //  val schedule = DB(this.context!!).dbSchedule(typeGroup, day)

            recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
          //  recycler.adapter = DayAdapter(schedule)
            recycler.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
            recycler.setHasFixedSize(true)


        }

}