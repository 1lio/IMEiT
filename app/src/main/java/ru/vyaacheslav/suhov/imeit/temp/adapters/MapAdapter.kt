package ru.vyaacheslav.suhov.imeit.temp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.vyaacheslav.suhov.imeit.temp.ftagments.maps.MapsList
import ru.vyaacheslav.suhov.imeit.temp.ftagments.maps.MapsLocation

/** Адаптер фрагментов Карты*/
internal class MapAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) MapsLocation() else MapsList()
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