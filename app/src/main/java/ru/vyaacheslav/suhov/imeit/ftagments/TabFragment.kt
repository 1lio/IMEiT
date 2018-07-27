package ru.vyaacheslav.suhov.imeit.ftagments

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.adapters.DayAdapter
import java.util.*

class TabFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_tab, container, false)
        val tabLayout = v.findViewById<TabLayout>(R.id.tabs)
        val viewPager = v.findViewById<ViewPager>(R.id.viewpager)

        viewPager.adapter = DayAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }

        val c = Calendar.getInstance()
        val dayOfWeek = c.get(Calendar.DAY_OF_WEEK)

        when (dayOfWeek) {
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