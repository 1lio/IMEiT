package ru.vyaacheslav.suhov.imeit.view.adapters

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.vyaacheslav.suhov.imeit.view.ftagments.maps.MapsListFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.maps.MapsMapFragment

/** Адаптер фрагментов Карты*/
class MapPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) = if (position == 0) MapsMapFragment() else MapsListFragment()

    override fun getCount() = 2

    override fun getPageTitle(position: Int) = if (position == 0) "Корпуса" else "Список"
}