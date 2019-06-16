package ru.vyaacheslav.suhov.imeit.view.adapters

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.util.Constants.FRI
import ru.vyaacheslav.suhov.imeit.util.Constants.MON
import ru.vyaacheslav.suhov.imeit.util.Constants.THU
import ru.vyaacheslav.suhov.imeit.util.Constants.TUE
import ru.vyaacheslav.suhov.imeit.util.Constants.WED
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.FragmentDay

class DayPagerAdapter(fm: FragmentManager, private val context:Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) =
            when (position) {
                0 -> FragmentDay(MON)
                1 -> FragmentDay(TUE)
                2 -> FragmentDay(WED)
                3 -> FragmentDay(THU)
                4 -> FragmentDay(FRI)
                else -> FragmentDay(MON)
            }

    override fun getCount() = 5

    override fun getPageTitle(position: Int) =
            when (position) {
                0 -> context.getString(R.string.day_mon)
                1 -> context.getString(R.string.day_tue)
                2 -> context.getString(R.string.day_wed)
                3 -> context.getString(R.string.day_thu)
                4 -> context.getString(R.string.day_fri)
                else -> null
            }
}