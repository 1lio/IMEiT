package ru.student.assistant.maps

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MapPagerAdapter(fm: FragmentManager, l: Lifecycle) : FragmentStateAdapter(fm, l) {

    private companion object {
        const val ITEM_COUNT: Int = 2
    }

    override fun createFragment(p: Int) = if (p == 0) MapsMapFragment() else MapsListFragment()

    override fun getItemCount() = ITEM_COUNT
}
