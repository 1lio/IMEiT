package ru.student.assistant.schedule.features.schedule

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.student.assistant.schedule.R
import ru.student.assistant.schedule.features.schedule.FragmentDay
import ru.student.core.Constants.FRI
import ru.student.core.Constants.MON
import ru.student.core.Constants.THU
import ru.student.core.Constants.TUE
import ru.student.core.Constants.WED

class DayPagerAdapter(fm: FragmentManager, private val context:Context) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

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