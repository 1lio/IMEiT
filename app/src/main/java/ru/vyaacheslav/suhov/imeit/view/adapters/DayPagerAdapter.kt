package ru.vyaacheslav.suhov.imeit.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.vyaacheslav.suhov.imeit.util.Constants.FRI
import ru.vyaacheslav.suhov.imeit.util.Constants.MON
import ru.vyaacheslav.suhov.imeit.util.Constants.THU
import ru.vyaacheslav.suhov.imeit.util.Constants.TUE
import ru.vyaacheslav.suhov.imeit.util.Constants.WED
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.*

class DayPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FragmentDay(MON)
       /*     1 -> FragmentDay(TUE)
            2 -> FragmentDay(WED)
            3 -> FragmentDay(THU)
            4 -> FragmentDay(FRI)
*/
             1 -> ScheduleTuesday(TUE)
             2 -> ScheduleWednesday(WED)
             3 -> ScheduleThursday(THU)
             4 -> ScheduleFriday(FRI)

            else -> FragmentDay(MON)
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