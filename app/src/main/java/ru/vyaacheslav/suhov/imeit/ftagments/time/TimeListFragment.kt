package ru.vyaacheslav.suhov.imeit.ftagments.time

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.vyaacheslav.suhov.imeit.R

class TimeListFragment : Fragment() {

    lateinit var timeData: List<TimeData>
    private lateinit var recycler: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val v = inflater.inflate(R.layout.time_list, container, false)
        recycler = v.findViewById(R.id.recycler_time_list)
        recycler.setHasFixedSize(true)

        val llm = LinearLayoutManager(context)
        recycler.layoutManager = llm

        initializeData()

        // Initialization adapter
        val adapter = TimeAdapter(timeData)
        recycler.adapter = adapter
        return v
    }

    private fun initializeData() {
        timeData = ArrayList()
        (timeData as ArrayList<TimeData>).add(TimeData(1, resources.getString(R.string.time01), resources.getString(R.string.time02)))
        (timeData as ArrayList<TimeData>).add(TimeData(2, resources.getString(R.string.time03), resources.getString(R.string.time04),
                itemBottomOut = resources.getString(R.string.min40)))
        (timeData as ArrayList<TimeData>).add(TimeData(3, resources.getString(R.string.time05), resources.getString(R.string.time06)))
        (timeData as ArrayList<TimeData>).add(TimeData(4, resources.getString(R.string.time07), resources.getString(R.string.time08)))
        (timeData as ArrayList<TimeData>).add(TimeData(5, resources.getString(R.string.time09), resources.getString(R.string.time10)))
        (timeData as ArrayList<TimeData>).add(TimeData(6, resources.getString(R.string.time11), resources.getString(R.string.time12)))
    }
}
