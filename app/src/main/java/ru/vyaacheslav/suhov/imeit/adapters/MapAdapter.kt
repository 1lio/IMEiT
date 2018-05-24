package ru.vyaacheslav.suhov.imeit.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ru.vyaacheslav.suhov.imeit.maps.Maps_Camus
import ru.vyaacheslav.suhov.imeit.maps.Maps_Inst
import ru.vyaacheslav.suhov.imeit.maps.Maps_Other

internal class MapAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return Maps_Inst()
            1 -> return Maps_Camus()
            2 -> return Maps_Other()
        }
        return null
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Институты"
            1 -> return "Корпуса"
            2 -> return "Прочее"
        }
        return null
    }
}
