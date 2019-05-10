package ru.vyaacheslav.suhov.imeit.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.*

class DayPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ScheduleMonday()
            1 -> ScheduleTuesday()
            2 -> ScheduleWednesday()
            3 -> ScheduleThursday()
            4 -> ScheduleFriday()
            else -> ScheduleMonday()
        }
    }

    override fun getCount(): Int = 5

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
            0 -> "Пн"
            1 -> "Вт"
            2 -> "Ср"
            3 -> "Чт"
            4 -> "Пт"
            else -> null
        }
}