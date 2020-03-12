package ru.suhov.student.features.map

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.suhov.student.features.map.MapsListFragment
import ru.suhov.student.features.map.MapsMapFragment

class MapPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = if (position == 0) MapsMapFragment() else MapsListFragment()

    override fun getCount() = 2

    override fun getPageTitle(position: Int) = if (position == 0) "Корпуса" else "Список"
}