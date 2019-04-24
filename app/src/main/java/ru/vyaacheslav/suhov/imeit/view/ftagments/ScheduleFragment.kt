package ru.vyaacheslav.suhov.imeit.view.ftagments

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.adapters.NumDayAdapter
import java.util.*

class ScheduleFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_tab, container, false)
        val tabLayout = v.findViewById<TabLayout>(R.id.tabs)
        val viewPager = v.findViewById<androidx.viewpager.widget.ViewPager>(R.id.viewpager)

        viewPager.adapter = NumDayAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }

        val c = Calendar.getInstance()

        when (c.get(Calendar.DAY_OF_WEEK)) {
            Calendar.MONDAY -> viewPager.setCurrentItem(0, true)
            Calendar.TUESDAY -> viewPager.setCurrentItem(1, true)
            Calendar.WEDNESDAY -> viewPager.setCurrentItem(2, true)
            Calendar.THURSDAY -> viewPager.setCurrentItem(3, true)
            Calendar.FRIDAY -> viewPager.setCurrentItem(4, true)
            Calendar.SATURDAY -> viewPager.setCurrentItem(0, true)
            Calendar.SUNDAY -> viewPager.setCurrentItem(0, true)
        }
        return v
    }
}