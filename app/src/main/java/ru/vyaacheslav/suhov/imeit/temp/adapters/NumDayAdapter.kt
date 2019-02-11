package ru.vyaacheslav.suhov.imeit.temp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.vyaacheslav.suhov.imeit.temp.ftagments.schedule.*

internal class NumDayAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {

            0 -> return ScheduleMonday()
            1 -> return ScheduleTuesday()
            2 -> return ScheduleWedneday()
            3 -> return ScheduleThursday()
            4 -> return ScheduleFriday()
        }
        return ScheduleMonday()
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {

        when (position) {
            0 -> return "Пн"
            1 -> return "Вт"
            2 -> return "Ср"
            3 -> return "Чт"
            4 -> return "Пт"
        }
        return null
    }
}