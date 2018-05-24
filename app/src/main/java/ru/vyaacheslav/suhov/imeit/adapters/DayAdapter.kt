package ru.vyaacheslav.suhov.imeit.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ru.vyaacheslav.suhov.imeit.days.*

internal class DayAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {

            0 -> return Mon()
            1 -> return Tue()
            2 -> return Wed()
            3 -> return Thu()
            4 -> return Fri()
        }
        return null
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