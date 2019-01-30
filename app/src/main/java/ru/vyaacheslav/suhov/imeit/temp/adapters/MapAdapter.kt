package ru.vyaacheslav.suhov.imeit.temp.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ru.vyaacheslav.suhov.imeit.temp.ftagments.maps.MapsList
import ru.vyaacheslav.suhov.imeit.temp.ftagments.maps.MapsLocation

/** Адаптер фрагментов Карты*/
internal class MapAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            // Фрагменты
            0 -> return MapsLocation()
            1 -> return MapsList()
        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Названия табов
        when (position) {
            0 -> return "Корпуса"
            1 -> return "Список"
        }
        return null
    }
}